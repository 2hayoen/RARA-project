package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService; //서비스와 연결


    @PostMapping("/create")
    // DB 저장
    public  String createBoard(BoardDTO boardDTO) {
        try {
            boardService.insertBoard(boardDTO);
            return "redirect:accept_detail";
        } catch (Exception e) {
            return "index";
        }
    }

    @GetMapping("/list")
    public String getAllBoards(Model model) {
        // 모든 게시물 정보 조회
        List<BoardDTO> boards = boardService.selectBoardsAll();
        model.addAttribute("boards", boards);
        return "accept_list"; // accept_list.html을 렌더링
    }

    @GetMapping("/{id}")
    public String getBoardById(@PathVariable Long id, Model model) {
        try {
            BoardDTO board = boardService.selectBoardById(id);
            model.addAttribute("board", board);
            return "test/board";
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