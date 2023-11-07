package com.rara.app.model.mapper;

import com.rara.app.dto.ChildDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChildMapper {

    void insertChild(ChildDTO childDTO);

    void deleteChild(@Param("id") long id);

    void updateChild(ChildDTO childDTO);

    void updateChildSetName(@Param("id") long id, @Param("name") String name);

    void updateChildSetBirth(@Param("id") long id, @Param("birth") String birth);

    void updateChildSetMTId(@Param("id") long id, @Param("mTId") long mTId);

    void updateChildSetMCId(@Param("id") long id, @Param("mCId") long mCId);

    void updateChildSetPhoto(@Param("id") long id, @Param("photo") String photo);

    void updateChildSetProperty(@Param("id") long id, @Param("property") String property);

    void updateChildSetNameOrBirthOrMTIdOrMCId(Map<String, Object> params);

    void updateChildSetPhotoOrProperty(Map<String, Object> params);

    void selectChildrenAll(Map<String, Object> params);

    void selectChildById(Map<String, Object> params);

    void selectChildByName(Map<String, Object> params);

    void selectChildByBirth(Map<String, Object> params);

    void selectChildByMTId(Map<String, Object> params);

    void selectChildByMCId(Map<String, Object> params);

}