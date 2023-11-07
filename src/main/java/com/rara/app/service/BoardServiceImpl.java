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

    @Autowired
    private BoardMapper boardMapper;

//    @Autowired
//    public BoardServiceImpl(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }

    @Override
    public void insertBoard(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardDTO> selectBoardsAll() {
        Map<String, Object> params = new HashMap<>();
        boardMapper.selectBoardsAll(params);
        return (List<BoardDTO>) params.get("cursor");
    }

    @Override
    public BoardDTO selectBoardById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        boardMapper.selectBoardById(params);

        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<BoardDTO> selectBoardByCategory(String category) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        boardMapper.selectBoardByCategory(params);
        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        return results;
    }

    @Override
    public List<BoardDTO> selectBoardByCategoryAndTitle(String category, String title) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("title", title);
        boardMapper.selectBoardByCategoryAndTitle(params);
        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        return results;
    }

    @Override
    public List<BoardDTO> selectBoardByCategoryAndContent(String category, String content) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("content", content);
        boardMapper.selectBoardByCategoryAndContent(params);
        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        return results;
    }

    @Override
    public List<BoardDTO> selectBoardByCategoryAndMId(String category, long mId) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("mId", mId);
        boardMapper.selectBoardByCategoryAndMId(params);
        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        return results;
    }

    @Override
    public void updateBoard(BoardDTO board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void updateTitle(long id, String title) {
        boardMapper.updateTitle(id, title);
    }

    @Override
    public void updateContent(long id, String content) {
        boardMapper.updateContent(id, content);
    }

    @Override
    public void updateCategory(long id, String category) {
        boardMapper.updateCategory(id, category);
    }

    @Override
    public void updateFile1(long id, String file1) {
        boardMapper.updateFile1(id, file1);
    }

    @Override
    public void updateFile2(long id, String file2) {
        boardMapper.updateFile2(id, file2);
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
