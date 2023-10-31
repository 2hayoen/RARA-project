package com.rara.app.model.mapper;

import com.rara.app.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MemberMapper {
    void insertMember(MemberDTO memberDTO);

    void deleteMember(@Param("id") Long id);

    void updateMember(MemberDTO memberDTO);

    void updateMemberSetEmailOrPwdOrNameOrPhNumOrAddr(Map<String, Object> params);

    void selectMembersAll(Map<String, Object> params);
    void selectMemberById(Map<String, Object> params);
    void selectMemberByEmail(Map<String, Object> params);

    void selectMemberBySeparatorAndNameOrPhNumOrMId(Map<String, Object> params);
    void selectMemberBySeparatorAndCenterAndNameOrClass_OrPosition(Map<String, Object> params);
}
