package com.rara.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rara.app.dto.ChildDTO;
import com.rara.app.dto.TutorialDTO;
import com.rara.app.model.mapper.ChildMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    ChildMapper childMapper;

    @Override
    public void insertChild(ChildDTO childDTO) throws Exception {
        childMapper.insertChild(childDTO);
    }

    @Override
    public void deleteChild(Long id) throws Exception {
        childMapper.deleteChild(id);
    }

    @Override
    public void updateChild(ChildDTO childDTO) throws Exception {
        childMapper.updateChild(childDTO);
    }

    @Override
    public void updateChildSetNameOrBirthOrMTIdOrMCId(Map<String, Object> params) {
        childMapper.updateChildSetNameOrBirthOrMTIdOrMCId(params);
    }

    @Override
    public void updateChildSetPhotoOrProperty(Map<String, Object> params) {
        childMapper.updateChildSetPhotoOrProperty(params);
    }

    @Override
    public List<ChildDTO> selectChildrenAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        childMapper.selectChildrenAll(params);
        return (List<ChildDTO>) params.get("cursor");
    }

    @Override
    public ChildDTO selectChildById(Long id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        childMapper.selectChildById(params);

        List<ChildDTO> results = (List<ChildDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<ChildDTO> selectChildByName(String name) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        childMapper.selectChildByName(params);

        List<ChildDTO> results = (List<ChildDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<ChildDTO> selectChildByBirth(String birth) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("birth", birth);

        childMapper.selectChildByBirth(params);

        List<ChildDTO> results = (List<ChildDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<ChildDTO> selectChildByMTId(Long mTId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mTId", mTId);

        childMapper.selectChildByMTId(params);

        List<ChildDTO> results = (List<ChildDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<ChildDTO> selectChildByMCId(Long mCId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mCId", mCId);

        childMapper.selectChildByMCId(params);

        List<ChildDTO> results = (List<ChildDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }
}
