package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


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
            String fileBoardPullPath1 = fileBoardPath + "/" + file1.getOriginalFilename();
            if (!file1.isEmpty()) {
                file1.transferTo(new File(fileBoardPullPath1));
                boardDTO.setFile1(fileBoardPullPath1);
            }
            String fileBoardPullPath2 = fileBoardPath + "/" + file2.getOriginalFilename();
            if (!file2.isEmpty()) {
                file2.transferTo(new File(fileBoardPullPath2));
                boardDTO.setFile2(fileBoardPullPath2);
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
//            return "redirect:Board_datailed_Calendar";
//        } catch (Exception e) {
//            return "index";
//        }
//    }

    @GetMapping("/list")
    public String getAllBoards(Model model) {
        // 모든 게시물 정보 조회
        List<BoardDTO> boards = boardService.selectBoardsAll();
        model.addAttribute("boards", boards);
        return "Board_All_list"; // Board_All_list.html을 렌더링
    }

    @GetMapping("/{id}")
    public String getBoardById(@PathVariable Long id, Model model) {
        try {
            BoardDTO board = boardService.selectBoardById(id);
            model.addAttribute("board", board);
            return "Board_datailed_Calendar";
        } catch (Exception e) {
            return "error";
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

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable long id, @RequestBody BoardDTO board) {
        board.setId(id);
        boardService.updateBoard(board);
    }

    @PatchMapping("/{id}/title")
    public void updateTitle(@PathVariable long id, @RequestBody String title) {
        // 요청된 URL 경로에 따라 게시물의 제목(Title)을 업데이트하는 컨트롤러 메서드
        boardService.updateTitle(id, title);
    }

    @PatchMapping("/{id}/content")
    public void updateContent(@PathVariable long id, @RequestBody String content) {
        boardService.updateContent(id, content);
    }

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