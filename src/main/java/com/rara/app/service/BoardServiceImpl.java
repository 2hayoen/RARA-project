package com.rara.app.service;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.ChildDTO;
import com.rara.app.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {


    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public void insertBoard(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardDTO> getBoardsAll() {
        Map<String, Object> params = new HashMap<>();
        boardMapper.selectBoardsAll(params);
        return (List<BoardDTO>) params.get("cursor");
    }

    @Override
    public BoardDTO getBoardById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        boardMapper.selectBoardsAll(params);

        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<BoardDTO> getBoardByCategoryAndTitle(String category, String title) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", category);
        paramMap.put("title", title);
        boardMapper.selectBoardByCategoryAndTitle(paramMap);
        List<BoardDTO> results = (List<BoardDTO>) paramMap.get("cursor");
        return results;
    }

    @Override
    public List<BoardDTO> getBoardByCategoryAndContent(String category, String content) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", category);
        paramMap.put("content", content);
        boardMapper.selectBoardByCategoryAndContent(paramMap);
        List<BoardDTO> results = (List<BoardDTO>) paramMap.get("cursor");
        return results;
    }

    @Override
    public List<BoardDTO> getBoardByCategoryAndMId(String category, long mId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", category);
        paramMap.put("mId", mId);
        boardMapper.selectBoardByCategoryAndMId(paramMap);
        List<BoardDTO> results = (List<BoardDTO>) paramMap.get("cursor");
        return results;
    }

    @Override
    public void updateBoard(BoardDTO board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void updateTitle(BoardDTO board) {
        boardMapper.updateTitle(board);
    }

    @Override
    public void updateContent(BoardDTO board) {
        boardMapper.updateContent(board);
    }

    @Override
    public void updateCategory(BoardDTO board) {
        boardMapper.updateCategory(board);
    }

    @Override
    public void updateFile1(BoardDTO board) {
        boardMapper.updateFile1(board);
    }

    @Override
    public void updateFile2(BoardDTO board) {
        boardMapper.updateFile2(board);
    }

    @Override
    public void deleteBoard(long id) {
        boardMapper.deleteBoard(id);
    }
}

//@Service
//public class BoardServiceImpl implements BoardService {
//
//    @Autowired
//    BoardMapper boardMapper;
//
//    @Override
//    public void insertBoard(BoardDTO boardDTO) throws Exception {
//        boardMapper.insertBoard(boardDTO);
//    }
//
//    @Override
//    public void deleteBoard(Long id) throws Exception {
//        boardMapper.deleteBoard(id);
//    }
//
//    @Override
//    public void updateBoard(BoardDTO boardDTO) throws Exception {
//        boardMapper.updateBoard(boardDTO);
//    }
//
//    @Override
//    public void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
//            Map<String, Object> params) throws Exception {
//        boardMapper.updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(params);
//    }
//
//    @Override
//    public List<BoardDTO> selectBoardsAll() throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        boardMapper.selectBoardsAll(params);
//        return (List<BoardDTO>) params.get("cursor");
//    }
//
//
//    @Override
//    public BoardDTO selectBoardById(Long id) throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
//        boardMapper.selectBoardById(params.size());
//
//        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
//        if (results != null && !results.isEmpty()) {
//            return results.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public List<BoardDTO> selectBoardByCategoryAndTitleOrContentOrMId(
//            Map<String, Object> params) throws Exception {
//        boardMapper.selectBoardByCategoryAndTitleOrContentOrMId(params);
//        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
//        if (results != null && !results.isEmpty()) {
//            return results;
//        }
//        return null;
//    }
//}
