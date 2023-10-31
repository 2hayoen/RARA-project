package com.rara.app.service;

import com.rara.app.dto.ChildDTO;

import java.util.List;

public interface ChildService {
    void createChild(ChildDTO childDTO) throws Exception;
    void deleteChild(Long id) throws Exception;
    void updateChild(ChildDTO childDTO) throws Exception;
    void updateChildName(Long id, String name);
    void updateChildBirth(Long id, String birth);
    void updateChildPhoto(Long id, String photo);
    void updateChildProperty(Long id, String property);
    void updateChildM_T_Id(Long id, Long m_t_id);
    void updateChildM_C_Id(Long id, Long m_c_id);
    List<ChildDTO> readAllChildren() throws Exception;
    List<ChildDTO> readChildById(Long id) throws Exception;
    List<ChildDTO> readChildByName(String name) throws Exception;
    List<ChildDTO> readChildByBirth(String birth) throws Exception;
    List<ChildDTO> readChildByM_T_Id(Long m_t_id) throws Exception;
    List<ChildDTO> readChildByM_C_Id(Long m_c_id) throws Exception;
}