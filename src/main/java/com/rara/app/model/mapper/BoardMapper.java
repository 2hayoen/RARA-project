package com.rara.app.model.mapper;

import com.rara.app.dto.BoardDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BoardMapper {

    void insertBoard(BoardDTO boardDTO);

    void deleteBoard(@Param("id") Long id);

    void updateBoard(BoardDTO boardDTO);

    void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
            Map<String, Object> params);

    void selectBoardsAll(Map<String, Object> params);

    void selectBoardById(Map<String, Object> params);

    void selectBoardByCategoryAndTitleOrContentOrMId(
            Map<String, Object> params);
}
