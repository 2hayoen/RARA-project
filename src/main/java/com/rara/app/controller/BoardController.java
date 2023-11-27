package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService; //서비스와 연결

    @GetMapping("/create")
    public String showCreateBoardForm(Model model) {
        // 게시물 작성 폼을 보여주기 위한 메서드
        // Board_create.html 페이지를 렌더링하고 필요한 모델을 설정
        model.addAttribute("boardDTO", new BoardDTO()); // 빈 BoardDTO 객체를 생성해 폼으로 전달
        return "Board_create"; // Board_create.html을 렌더링
    }

    @Value("${spring.servlet.multipart.location}")
    String fileInputPath;

    @Value("${files.boards.location}")
    String fileBoardPath;

    @PostMapping("/create")
    // 게시물 생성 처리
    public String createBoard(BoardDTO boardDTO,
                              @RequestParam("fileFirst") MultipartFile file1,
                              @RequestParam("fileSecond") MultipartFile file2)
            throws IllegalStateException, IOException {
        try {

            String fileName = UUID.randomUUID().toString() + "_" + file1.getOriginalFilename();
            String fileBoardFullPath1 = fileBoardPath + "/" + fileName;

            if (!file1.isEmpty()) {
                if (!(new File(fileBoardFullPath1)).exists()) {
                    (new File(fileBoardFullPath1)).mkdirs();
                }
                file1.transferTo(new File(fileBoardFullPath1));
                boardDTO.setFile1(fileName);
            }

            fileName = UUID.randomUUID().toString() + "_" + file2.getOriginalFilename();
            String fileBoardFullPath2 = fileBoardPath + "/" + fileName;
            if (!file2.isEmpty()) {
                if (!(new File(fileBoardFullPath2)).exists()) {
                    (new File(fileBoardFullPath2)).mkdirs();
                }
                file2.transferTo(new File(fileBoardFullPath2));
                boardDTO.setFile2(fileName);
            }

            boardService.insertBoard(boardDTO);
            return "redirect:list"; // 게시물 생성 후 목록 페이지로 리다이렉션
        } catch (Exception e) {
            return "index"; // 예외 발생 시 index 페이지로 이동
        }
    }

//    @PostMapping("/create")
//    // 게시물 생성 처리
//    public String createBoard(@ModelAttribute("boardDTO") BoardDTO boardDTO) {
//        try {
//            // boardService를 사용하여 게시물 생성
//            boardService.insertBoard(boardDTO);
//            return "redirect:list"; // 게시물 생성 후 목록 페이지로 리다이렉션
//        } catch (Exception e) {
//            return "index"; // 예외 발생 시 index 페이지로 이동
//        }
//    }


//    @PostMapping("/create")
//    // DB 저장
//    public  String createBoard(BoardDTO boardDTO) {
//        try {
//            boardService.insertBoard(boardDTO);
//            return "redirect:Board_detailed_Calendar";
//        } catch (Exception e) {
//            return "index";
//        }
//    }

    @GetMapping("/list")
    public String getAllBoards(@RequestParam(value = "page", defaultValue = "1") int page,
                               Model model) {
        // 모든 게시물 정보 조회
        List<BoardDTO> allBoards = boardService.selectBoardsAll()
                .stream()
                .sorted(Comparator.comparing(BoardDTO::getId).reversed())
                .toList();

        int size = 10;

        int totalItems = allBoards.size();
        int totalPages = (totalItems + size - 1) / size; // 전체 페이지 수 계산

        int start = (page - 1) * size;
        int end = Math.min(start + size, totalItems);

        List<BoardDTO> boards = allBoards.subList(start, end); // 현재 페이지에 해당하는 게시물

        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);


        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = Math.min(startPage + 9, totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "Board_All_list"; // Board_All_list.html을 렌더링
    }

    @GetMapping("/{id}")
    public String getBoardById(@PathVariable Long id, Model model) {
        try {
            BoardDTO board = boardService.selectBoardById(id);
            if (board.getFile1() != null) {
                board.setFile1(board.getFile1().substring(board.getFile1().indexOf("_") + 1));
            }
            if (board.getFile2() != null) {
                board.setFile2(board.getFile2().substring(board.getFile2().indexOf("_") + 1));
            }
            model.addAttribute("board", board);
            return "Board_detailed_Calendar";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/{id}/file1")
    public ResponseEntity<Resource> downloadFile1(@PathVariable Long id) {
        try {
            BoardDTO boardDTO = boardService.selectBoardById(id);

            Path path = Paths.get(fileBoardPath + "/" + boardDTO.getFile1());
            String contentType = Files.probeContentType(path);
            // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(boardDTO.getFile1().substring(boardDTO.getFile1().indexOf("_") + 1),
                            StandardCharsets.UTF_8)
                    .build());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            Resource resource = new InputStreamResource(Files.newInputStream(path));
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/file2")
    public ResponseEntity<Resource> downloadFile2(@PathVariable Long id) {
        try {
            BoardDTO boardDTO = boardService.selectBoardById(id);

            Path path = Paths.get(fileBoardPath + "/" + boardDTO.getFile2());
            String contentType = Files.probeContentType(path);
            // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(boardDTO.getFile2().substring(boardDTO.getFile2().indexOf("_") + 1),
                            StandardCharsets.UTF_8)
                    .build());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            Resource resource = new InputStreamResource(Files.newInputStream(path));
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/title")
//        public List<BoardDTO> getBoardByCategoryAndTitle(@RequestParam String category, @RequestParam String title) {
//            return boardService.getBoardByCategoryAndTitle(category, title);
//    }
//
//    @GetMapping("/content")
//    public List<BoardDTO> getBoardByCategoryAndContent(@RequestParam String category, @RequestParam String content) {
//        return boardService.getBoardByCategoryAndContent(category, content);
//    }
//
//    @GetMapping("/mid")
//    public List<BoardDTO> getBoardByCategoryAndMId(@RequestParam String category, @RequestParam long mId) {
//        return boardService.getBoardByCategoryAndMId(category, mId);
//    }

//    @PutMapping("/{id}")
//    public void updateBoard(@PathVariable long id, @RequestBody BoardDTO board) {
//        board.setId(id);
//        boardService.updateBoard(board);
//    }
//
//    @PatchMapping("/{id}/title")
//    public void updateTitle(@PathVariable long id, @RequestBody String title) {
//        // 요청된 URL 경로에 따라 게시물의 제목(Title)을 업데이트하는 컨트롤러 메서드
//        boardService.updateTitle(id, title);
//    }
//
//    @PatchMapping("/{id}/content")
//    public void updateContent(@PathVariable long id, @RequestBody String content) {
//        boardService.updateContent(id, content);
//    }

//    @PatchMapping("/{id}/category")
//    public void updateCategory(@PathVariable long id, @RequestBody BoardDTO board) {
//        board.setId(id);
//        boardService.updateCategory(board);
//    }

//    @PatchMapping("/{id}/file1")
//    public void updateFile1(@PathVariable long id, @RequestBody BoardDTO board) {
//        board.setId(id);
//        boardService.updateFile1(board);
//    }
//
//    @PatchMapping("/{id}/file2")
//    public void updateFile2(@PathVariable long id, @RequestBody BoardDTO board) {
//        board.setId(id);
//        boardService.updateFile2(board);
//    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
    }
}