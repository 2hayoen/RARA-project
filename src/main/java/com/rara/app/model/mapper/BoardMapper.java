package com.rara.app.model.mapper;

import com.rara.app.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDTO board);

    void  selectBoardsAll(Map<String, Object> params);

    void selectBoardById(Map<String, Object> params);

    void selectBoardByCategoryAndTitle(Map<String, Object> params);

    void selectBoardByCategoryAndContent(Map<String, Object> params);

    void selectBoardByCategoryAndMId(Map<String, Object> params);

    void updateBoard(BoardDTO board);

    void updateTitle(BoardDTO board);

    void updateContent(BoardDTO board);

    void updateCategory(BoardDTO board);

    void updateFile1(BoardDTO board);

    void updateFile2(BoardDTO board);

    void deleteBoard(long id);
}

//public interface BoardMapper {
//
//    void insertBoard(BoardDTO boardDTO);
//
//    void deleteBoard(@Param("id") Long id);
//
//    void updateBoard(BoardDTO boardDTO);
//
//    void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
//            Map<String, Object> params);
//
//    void selectBoardsAll(Map<String, Object> params);
//
//    void selectBoardById(Map<String, Object> params);
//
//    void selectBoardByCategoryAndTitleOrContentOrMId(
//            Map<String, Object> params);
//}
