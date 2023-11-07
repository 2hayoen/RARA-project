package com.rara.app.model.mapper;

import com.rara.app.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDTO board);

    void selectBoardsAll(Map<String, Object> params);

    void selectBoardById(Map<String, Object> params);

    void selectBoardByCategory(Map<String, Object> params);

    void selectBoardByCategoryAndTitle(Map<String, Object> params);

    void selectBoardByCategoryAndContent(Map<String, Object> params);

    void selectBoardByCategoryAndMId(Map<String, Object> params);

    void updateBoard(BoardDTO board);

    void updateTitle(@Param("id") long id, @Param("title") String title);

    void updateContent(@Param("id") long id, @Param("content") String content);

    void updateCategory(@Param("id") long id, @Param("category") String category);

    void updateFile1(@Param("id") long id, @Param("file1") String file1);

    void updateFile2(@Param("id") long id, @Param("file2") String file2);

    void deleteBoard(@Param("id") long id);
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
