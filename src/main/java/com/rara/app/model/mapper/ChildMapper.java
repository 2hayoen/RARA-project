package com.rara.app.model.mapper;

import com.rara.app.dto.ChildDTO;

import java.util.List;

public interface ChildMapper {
    void insertChild(ChildDTO childDTO);
    void deleteChild(Long id);
    void updateChild(ChildDTO childDTO);
    List<ChildDTO> selectAllChildren();
    List<ChildDTO> selectChildById(Long id);
    List<ChildDTO> selectChildByName(String name);
    List<ChildDTO> selectChildByBirth(String birth);
    List<ChildDTO> selectChildByM_T_Id(Long m_t_id);
    List<ChildDTO> selectChildByM_C_Id(Long m_c_id);
    void updateChildName(Long id, String name);
    void updateChildBirth(Long id, String birth);
    void updateChildPhoto(Long id, String photo);
    void updateChildProperty(Long id, String property);
    void updateChildM_T_Id(Long id, Long m_t_id);
    void updateChildM_C_Id(Long id, Long m_c_id);
}