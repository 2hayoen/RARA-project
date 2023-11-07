package com.rara.app.model.mapper;

import com.rara.app.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MemberMapper {
    void insertMember(MemberDTO memberDTO);

    void deleteMember(@Param("id") long id);

    void updateMember(MemberDTO memberDTO);

    void updateMemberSetEmail(@Param("id") long id, @Param("email") String email);

    void updateMemberSetPwd(@Param("id") long id, @Param("pwd") String pwd);

    void updateMemberSetName(@Param("id") long id, @Param("name") String name);

    void updateMemberSetPhNum(@Param("id") long id, @Param("phNum") String phNum);

    void updateMemberSetAddr(@Param("id") long id, @Param("addr") String addr);

    void selectMembersAll(Map<String, Object> params);

    void selectMemberById(Map<String, Object> params);

    void selectMemberByEmail(Map<String, Object> params);

    void selectMemberBySeparator(Map<String, Object> params);

    void selectMemberBySeparatorAndName(Map<String, Object> params);

    void selectMemberBySeparatorAndPhNum(Map<String, Object> params);

    void selectMemberBySeparatorAndMId(Map<String, Object> params);

    void selectMemberBySeparatorAndCenter(Map<String, Object> params);

    void selectMemberBySeparatorAndCenterAndName(Map<String, Object> params);

    void selectMemberBySeparatorAndCenterAndClass_(Map<String, Object> params);

    void selectMemberBySeparatorAndCenterAndPosition(Map<String, Object> params);
}
