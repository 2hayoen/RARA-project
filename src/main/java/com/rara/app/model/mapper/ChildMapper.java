package com.rara.app.model.mapper;

import com.rara.app.dto.ChildDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChildMapper {

    void insertChild(ChildDTO childDTO);

    void deleteChild(@Param("id") Long id);

    void updateChild(ChildDTO childDTO);

    void updateChildSetNameOrBirthOrMTIdOrMCId(Map<String, Object> params);

    void updateChildSetPhotoOrProperty(Map<String, Object> params);

    void selectChildrenAll(Map<String, Object> params);

    void selectChildById(Map<String, Object> params);

    void selectChildByName(Map<String, Object> params);

    void selectChildByBirth(Map<String, Object> params);

    void selectChildByMTId(Map<String, Object> params);

    void selectChildByMCId(Map<String, Object> params);
    
}