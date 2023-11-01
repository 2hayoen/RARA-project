package com.rara.app.service;

import com.rara.app.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    void insertBoard(BoardDTO boardDTO) throws Exception;

    void deleteBoard(Long id) throws Exception;

    void updateBoard(BoardDTO boardDTO) throws Exception;

    void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
            Map<String, Object> params) throws Exception;


    List<BoardDTO> selectBoardsAll() throws Exception;

    BoardDTO selectBoardById(Long id) throws Exception;

    List<BoardDTO> selectBoardByCategoryAndTitleOrContentOrMId(
            Map<String, Object> params) throws Exception;

}
