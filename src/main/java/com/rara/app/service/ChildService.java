package com.rara.app.service;

import com.rara.app.dto.ChildDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChildService {
    void insertChild(ChildDTO childDTO) throws Exception;

    void deleteChild(Long id) throws Exception;

    void updateChild(ChildDTO childDTO) throws Exception;

    void updateChildSetName(long id, String name);

    void updateChildSetBirth(long id, String birth);

    void updateChildSetMTId(long id, long mTId);

    void updateChildSetMCId(long id, long mCId);

    void updateChildSetPhoto(long id, String photo);

    void updateChildSetProperty(long id, String property);
    
    List<ChildDTO> selectChildrenAll() throws Exception;

    ChildDTO selectChildById(Long id) throws Exception;

    List<ChildDTO> selectChildByName(String name) throws Exception;

    List<ChildDTO> selectChildByBirth(String birth) throws Exception;

    List<ChildDTO> selectChildByMTId(Long mTId) throws Exception;

    List<ChildDTO> selectChildByMCId(Long mCId) throws Exception;

}