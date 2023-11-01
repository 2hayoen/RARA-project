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
    public void createChild(ChildDTO childDTO) throws Exception {
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
    public void updateChildName(Long id, String name) {
        childMapper.updateChildName(id, name);
    }


    @Override
    public void updateChildBirth(Long id, String birth) {
        childMapper.updateChildBirth(id, birth);
    }

    @Override
    public void updateChildPhoto(Long id, String photo) {
        childMapper.updateChildPhoto(id, photo);
    }

    @Override
    public void updateChildProperty(Long id, String property) {
        childMapper.updateChildProperty(id, property);
    }

    @Override
    public void updateChildM_T_Id(Long id, Long m_t_id) {
        childMapper.updateChildM_T_Id(id, m_t_id);
    }

    @Override
    public void updateChildM_C_Id(Long id, Long m_c_id) {
        childMapper.updateChildM_C_Id(id, m_c_id);
    }

    @Override
    public List<ChildDTO> readAllChildren() throws Exception {
        Map<String, Object> params = new HashMap<>();
        childMapper.selectAllChildren(params);
        return (List<ChildDTO>) params.get("cursor");
    }

    @Override
    public List<ChildDTO> readChildById(Long id) throws Exception {
        return childMapper.selectChildById(id);
    }

    @Override
    public List<ChildDTO> readChildByName(String name) throws Exception {
        return childMapper.selectChildByName(name);
    }

    @Override
    public List<ChildDTO> readChildByBirth(String birth) throws Exception {
        return childMapper.selectChildByBirth(birth);
    }

    @Override
    public List<ChildDTO> readChildByM_T_Id(Long m_t_id) throws Exception {
        return childMapper.selectChildByM_T_Id(m_t_id);
    }

    @Override
    public List<ChildDTO> readChildByM_C_Id(Long m_c_id) throws Exception {
        return childMapper.selectChildByM_C_Id(m_c_id);
    }
}
