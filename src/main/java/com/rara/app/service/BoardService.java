package com.rara.app.service;

import com.rara.app.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    void insertBoard(BoardDTO board);

    List<BoardDTO> getBoardsAll();

    BoardDTO getBoardById(long id);

    List<BoardDTO> getBoardByCategoryAndTitle(String category, String title);

    List<BoardDTO> getBoardByCategoryAndContent(String category, String content);

    List<BoardDTO> getBoardByCategoryAndMId(String category, long mId);

    void updateBoard(BoardDTO board);

    void updateTitle(BoardDTO board);

    void updateContent(BoardDTO board);

    void updateCategory(BoardDTO board);

    void updateFile1(BoardDTO board);

    void updateFile2(BoardDTO board);

    void deleteBoard(long id);
}

//public interface BoardService {
//
//    void insertBoard(BoardDTO boardDTO) throws Exception;
//
//    void deleteBoard(Long id) throws Exception;
//
//    void updateBoard(BoardDTO boardDTO) throws Exception;
//
//    void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
//            Map<String, Object> params) throws Exception;
//
//
//    List<BoardDTO> selectBoardsAll() throws Exception;
//
//    BoardDTO selectBoardById(Long id) throws Exception;
//
//    List<BoardDTO> selectBoardByCategoryAndTitleOrContentOrMId(
//            Map<String, Object> params) throws Exception;
//
//}
