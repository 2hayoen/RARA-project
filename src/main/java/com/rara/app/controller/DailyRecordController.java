package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.ChildDTO;
import com.rara.app.dto.DailyRecordDTO;
import com.rara.app.dto.MemberDTO;
import com.rara.app.service.ChildService;
import com.rara.app.service.DailyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/records")
public class DailyRecordController {

    @Autowired
    DailyRecordService dailyRecordService;

    @Autowired
    ChildService childService;

    @Value("${spring.servlet.multipart.location}")
    String fileInputPath;

    @Value("${files.dailyRecords.location}")
    String fileRecordsPath;

    @GetMapping("/list")
    public String childrenListPage(Model model) {
        try {
            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long id = member.getId();

            if (member.getSeparator().equals("학부모")) {
                model.addAttribute("children", childService.selectChildByMCId(id));
            } else {
                model.addAttribute("children", childService.selectChildByMTId(id));
            }

            return "childrenList";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/child/{id}")
    public String imagesOfChild(@RequestParam(value = "page", defaultValue = "1") int page,
                                Model model, @PathVariable Long id) {
        try {

            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long mId = member.getId();

            ChildDTO childDTO = childService.selectChildById(id);

            if (childDTO.getMCId().longValue() != mId.longValue()
                    && childDTO.getMTId().longValue() != mId.longValue()) {
                throw new Exception();
            }

            List<DailyRecordDTO> dailyRecordDTOAll = dailyRecordService.selectDailyRecordByCId(id)
                    .stream()
                    .sorted(Comparator.comparing(DailyRecordDTO::getId).reversed())
                    .toList();

            int size = 9;

            int totalItems = dailyRecordDTOAll.size();
            int totalPages = (totalItems + size - 1) / size; // 전체 페이지 수 계산

            int start = (page - 1) * size;
            int end = Math.min(start + size, totalItems);

            List<DailyRecordDTO> dailyRecordDTOList = dailyRecordDTOAll.subList(start, end);


            if (!dailyRecordDTOList.isEmpty()) {
                for (DailyRecordDTO dr : dailyRecordDTOList) {
                    if (!dr.getFile1().isEmpty()) {
                        dr.setFile1(fileRecordsPath.replace("\\\\", "/")
                                .substring(2)
                                + "/" + dr.getFile1());
                    }
                }
            }

            model.addAttribute("records", dailyRecordDTOList);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);


            int startPage = (page - 1) / 10 * 10 + 1;
            int endPage = Math.min(startPage + 9, totalPages);

            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);

            return "imagesOfChild";
        } catch (Exception e) {
            return "redirect:/records/list";
        }
    }

    @GetMapping("/imageUpload")
    public String uploadImagesPage() {
        return "imageUpload";
    }

    @PostMapping("/imageUpload")
    public String uploadImages(@RequestParam("images") MultipartFile[] images)
            throws IllegalStateException, IOException {
        try {
            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long id = member.getId();

            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    String fileName = id.toString() + "-"
                            + UUID.randomUUID().toString() + "_"
                            + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString() + "_"
                            + file.getOriginalFilename();
                    // 전달된 내용을 실제 물리적인 파일로 저장해준다.
                    file.transferTo(new File(fileInputPath + "/" + fileName));
                }
            }

            return "redirect:/records/list";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/{id}/file1")
    public ResponseEntity<Resource> downloadFile1(@PathVariable Long id) {
        try {
            DailyRecordDTO dailyRecordDTO = dailyRecordService.selectDailyRecordById(id);

            Path path = Paths.get(fileRecordsPath + "/" + dailyRecordDTO.getFile1());
            String contentType = Files.probeContentType(path);
            // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(dailyRecordDTO.getFile1()
                                    .substring(dailyRecordDTO.getFile1().indexOf("_") + 1),
                            StandardCharsets.UTF_8)
                    .build());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            Resource resource = new InputStreamResource(Files.newInputStream(path));
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
