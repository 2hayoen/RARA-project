package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.dto.FileDTO;
import com.rara.app.dto.MemberDTO;
import com.rara.app.service.DailyPlanService;
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

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/act")
public class DailyPlanController {

    @Autowired
    DailyPlanService dailyPlanService;

//    @GetMapping  // 접근 URL
//    public String getDailyPlansAll(Model model) {
//        try {
//            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlansAll();
//            // dailyPlanService를 호출. DailyPlan을 데이터베이스에서 검색
//            // 이 정보를 DailyPlanDTO 객체의 목록 형태로 가져옴
//            model.addAttribute("dailyPlans", dailyPlans);
//            // model 객체를 사용. "dailyPlans"라는 속성 이름으로 dailyPlans 목록을 뷰에 전달
//            // 이를 통해 뷰에서 이 데이터를 사용할 수 있음
//            return "schedule2";
//            // schedule"라는 뷰 이름을 반환하여 해당 뷰를 렌더링
//            // Thymeleaf 템플릿 엔진에서 "schedule.html" 템플릿을 찾아 클라이언트에게 반환하도록 요청
//        } catch (Exception e) {
//            return "error"; // 예외가 발생하면 "error" 뷰로 리디렉션
//        }
//    }

//    @GetMapping("/test")
//    public String testDailyPlansAll(Model model) {
//        try {
//            List<DailyPlanDTO> dailyPlanDTOList = dailyPlanService.selectDailyPlansAll();
//            for (DailyPlanDTO dp : dailyPlanDTOList) {
//                String dpIdStr = Long.toString(dp.getId());
//                DailyPlanDTO dp_u = DailyPlanDTO.builder()
//                        .id(dp.getId()).year(dp.getYear()).month(dp.getMonth()).mId(dp.getMId())
//                        .day(dp.getId())
//                        .key1(dp.getKey1() + dpIdStr)
//                        .act1Title("title" + dpIdStr)
//                        .act1Type("type" + dpIdStr)
//                        .act1Time(90L)
//                        .act1Goal("goal" + dpIdStr)
//                        .act1Desc("desc" + dpIdStr)
//                        .act1Mater("mater" + dpIdStr)
//                        .build();
//                dailyPlanService.updateDailyPlan(dp_u);
//            }
//            List<DailyPlanDTO> dailyPlanDTOList_u = dailyPlanService.selectDailyPlansAll();
//            model.addAttribute("dailyplans", dailyPlanDTOList_u);
//            return "test/dailyPlans";
//
//        } catch (Exception e) {
//            return "error";
//        }
//    }

    @GetMapping("/list")
    public String getDailyPlans(Model model) {

        try {
            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long mId = member.getId();

            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlanByMId(mId)
                    .stream()
                    .sorted(Comparator.comparing(DailyPlanDTO::getId).reversed())
                    .toList();

            for (DailyPlanDTO dailyPlanDTO : dailyPlans) {
                if (!dailyPlanDTO.getFile1().isBlank()) {
                    dailyPlanDTO.setFile1(
                            dailyPlanDTO.getFile1().substring(
                                    dailyPlanDTO.getFile1().indexOf("_") + 1));
                }
                if (!dailyPlanDTO.getFile2().isBlank()) {
                    dailyPlanDTO.setFile2(
                            dailyPlanDTO.getFile2().substring(
                                    dailyPlanDTO.getFile2().indexOf("_") + 1));

                }
            }

            model.addAttribute("dailyPlans", dailyPlans);
            return "Teacher_Act_list";
        } catch (Exception e) {
            return "error";
        }
    }

    @Value("${spring.servlet.multipart.location}")
    String fileInputPath;

    @Value("${files.dailyPlans.location}")
    String fileDailyPlansPath;

    @GetMapping
    public String pageDP() {
        return "Act_input";
    }

    @PostMapping
    // DB 저장
    public String createDP(DailyPlanDTO dailyPlanDTO) {
        try {
//            dailyPlanService.insertDailyPlan(dailyPlanDTO);
            BufferedOutputStream bs = null;
            String fileName = UUID.randomUUID().toString() + "_" + dailyPlanDTO.getYear().toString() + "_"
                    + dailyPlanDTO.getMonth().toString() + ".txt";
            try {
                bs = new BufferedOutputStream(new FileOutputStream(fileInputPath + "/" + fileName));
                String str = dailyPlanDTO.getYear().toString() + ","
                        + dailyPlanDTO.getMonth().toString() + ","
                        + "25" + ","
                        + dailyPlanDTO.getMId().toString() + ","
                        + dailyPlanDTO.getKey1() + ","
                        + dailyPlanDTO.getKey2() + ","
                        + dailyPlanDTO.getKey3();
                bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                bs.close();
            }
            return "redirect:/act";
        } catch (Exception e) {
            return "redirect:/act";
        }
    }

    @PostMapping("/act")
    public String updateAct(DailyPlanDTO dailyPlanDTO) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id", dailyPlanDTO.getId());
            params.put("act1Title", dailyPlanDTO.getAct1Title());
            params.put("act1Type", dailyPlanDTO.getAct1Type());
            params.put("act1Goal", dailyPlanDTO.getAct1Goal());
            params.put("act1Time", dailyPlanDTO.getAct1Time());
            params.put("act1Desc", dailyPlanDTO.getAct1Desc());
            params.put("act1Mater", dailyPlanDTO.getAct1Mater());
            params.put("act1Sub", dailyPlanDTO.getAct1Sub());
            System.out.println(dailyPlanDTO);
            dailyPlanService.updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);
            return "redirect:/act";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/fileUpdate")
// 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
    public String fileUpdate(DailyPlanDTO dailyPlanDTO, @RequestParam("file") MultipartFile file)
            throws IllegalStateException, IOException {

        try {
            DailyPlanDTO tempDailyPlanDTO = dailyPlanService.selectDailyPlanByMIdAndYear(
                            dailyPlanDTO.getMId(), dailyPlanDTO.getYear())
                    .stream()
                    .filter(dp -> dp.getMonth() == dailyPlanDTO.getMonth())
                    .toList().get(0);

            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String fileFullPath = fileDailyPlansPath + "/" + fileName;

            if (!file.isEmpty()) {
                if (!(new File(fileFullPath)).exists()) {
                    (new File(fileFullPath)).mkdirs();
                }
                file.transferTo(new File(fileFullPath));
                tempDailyPlanDTO.setFile1(fileName);
            }

            dailyPlanService.updateDailyPlan(tempDailyPlanDTO);

            return "redirect:/mypage";
        } catch (Exception e) {
            return "error";
        }

    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile1(
            @RequestParam("email") String email,
            @RequestParam("year") Long year,
            @RequestParam("month") Long month)
            throws IOException {

        try {
            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String emailSecurity = member.getEmail();

            if (emailSecurity.equals(email) == false) {
                throw new Exception();
            }

            Long mId = member.getId();

            DailyPlanDTO dailyPlanDTO = dailyPlanService
                    .selectDailyPlanByMIdAndYear(mId, year).stream()
                    .filter(dp -> dp.getMonth() == month)
                    .toList().get(0);

            Path path = Paths.get(fileDailyPlansPath + "/" + dailyPlanDTO.getFile1());
            String contentType = Files.probeContentType(path);
            // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(dailyPlanDTO.getFile1()
                                    .substring(dailyPlanDTO.getFile1().indexOf("_") + 1),
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
