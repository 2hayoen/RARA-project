package com.rara.app.service;

import com.rara.app.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Map;

public interface MemberService {

    public PasswordEncoder passwordEncoder();

    void insertMember(MemberDTO memberDTO) throws Exception;

    void deleteMember(Long id) throws Exception;

    void updateMember(MemberDTO memberDTO) throws Exception;

    void updateMemberSetEmailOrPwdOrNameOrPhNumOrAddr(
            Map<String, Object> params) throws Exception;

    List<MemberDTO> selectMembersAll() throws Exception;

    MemberDTO selectMemberById(Long id) throws Exception;

    MemberDTO selectMemberByEmail(String email) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndNameOrPhNumOrMId(
            Map<String, Object> params) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndCenterAndNameOrClass_OrPosition(
            Map<String, Object> params) throws Exception;
}
