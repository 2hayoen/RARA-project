package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//public class BoardController {
//
////    @GetMapping("/noticeboard")
////    public String noticeboard(Model model) {
////        return "noticeboard";
////    }
//}

@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService; //서비스와 연결

//    @Autowired
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    @PostMapping
    public void createBoard(@RequestBody BoardDTO board) {
        // 게시물 저장
        boardService.insertBoard(board);
    }

    @GetMapping("/boards")
    public String getAllBoards(Model model) {
        // 모든 게시물 정보 조회
        List<BoardDTO> boards = boardService.selectBoardsAll();
        model.addAttribute("boards", boards);
        return "accept_list"; // accept_list.html을 렌더링
    }

    @GetMapping("/{id}")
    public BoardDTO getBoardById(@PathVariable long id) {
        // URL 경로에서 추출한 ID를 사용하여 해당 ID의 게시물 정보를 조회
        return boardService.selectBoardById(id);
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