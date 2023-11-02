package com.rara.app.service;

import com.rara.app.dto.ChildDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChildService {
    void insertChild(ChildDTO childDTO) throws Exception;

    void deleteChild(Long id) throws Exception;

    void updateChild(ChildDTO childDTO) throws Exception;

    void updateChildSetNameOrBirthOrMTIdOrMCId(Map<String, Object> params);
//    void updateChildName(Long id, String name);
//    void updateChildBirth(Long id, String birth);
//    void updateChildM_T_Id(Long id, Long m_t_id);
//    void updateChildM_C_Id(Long id, Long m_c_id);

    void updateChildSetPhotoOrProperty(Map<String, Object> params);
//    void updateChildPhoto(Long id, String photo);
//    void updateChildProperty(Long id, String property);

    List<ChildDTO> selectChildrenAll() throws Exception;

    ChildDTO selectChildById(Long id) throws Exception;

    List<ChildDTO> selectChildByName(String name) throws Exception;

    List<ChildDTO> selectChildByBirth(String birth) throws Exception;

    List<ChildDTO> selectChildByMTId(Long mTId) throws Exception;

    List<ChildDTO> selectChildByMCId(Long mCId) throws Exception;

}