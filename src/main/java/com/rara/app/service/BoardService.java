package com.rara.app.service;

import com.rara.app.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    void insertBoard(BoardDTO board);

    List<BoardDTO> selectBoardsAll();

    BoardDTO selectBoardById(long id);

    List<BoardDTO> selectBoardByCategory(String category);

    List<BoardDTO> selectBoardByCategoryAndTitle(String category, String title);

    List<BoardDTO> selectBoardByCategoryAndContent(String category, String content);

    List<BoardDTO> selectBoardByCategoryAndMId(String category, long mId);

    void updateBoard(BoardDTO board);

    void updateTitle(long id, String title);

    void updateContent(long id, String content);

    void updateCategory(long id, String category);

    void updateFile1(long id, String file1);

    void updateFile2(long id, String file2);

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
