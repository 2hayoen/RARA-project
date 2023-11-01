package com.rara.app.service;

import com.rara.app.dto.BoardDTO;
import com.rara.app.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardDTO boardDTO) throws Exception {
        boardMapper.insertBoard(boardDTO);
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardMapper.deleteBoard(id);
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) throws Exception {
        boardMapper.updateBoard(boardDTO);
    }

    @Override
    public void updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(
            Map<String, Object> params) throws Exception {
        boardMapper.updateBoardSetTitleOrContentOrCategoryOrFile1OrFile2(params);
    }

    @Override
    public List<BoardDTO> selectBoardsAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        boardMapper.selectBoardsAll(params);
        return (List<BoardDTO>) params.get("cursor");
    }


    @Override
    public BoardDTO selectBoardById(Long id) throws Exception {
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
    public List<BoardDTO> selectBoardByCategoryAndTitleOrContentOrMId(
            Map<String, Object> params) throws Exception {
        boardMapper.selectBoardByCategoryAndTitleOrContentOrMId(params);
        List<BoardDTO> results = (List<BoardDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }
}
