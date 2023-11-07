package com.rara.app.service;

import com.rara.app.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Map;

public interface MemberService {

    public PasswordEncoder passwordEncoder();

    void insertMember(MemberDTO memberDTO) throws Exception;

    void deleteMember(long id) throws Exception;

    void updateMember(MemberDTO memberDTO) throws Exception;

    void updateMemberSetEmail(long id, String email) throws Exception;

    void updateMemberSetPwd(long id, String pwd) throws Exception;

    void updateMemberSetName(long id, String name) throws Exception;

    void updateMemberSetPhNum(long id, String phNum) throws Exception;

    void updateMemberSetAddr(long id, String addr) throws Exception;


    List<MemberDTO> selectMembersAll() throws Exception;

    MemberDTO selectMemberById(long id) throws Exception;

    MemberDTO selectMemberByEmail(String email) throws Exception;

    List<MemberDTO> selectMemberBySeparator(String separator) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndName(String separator, String name) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndPhNum(String separator, String phNum) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndMId(String separator, long mId) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndCenter(String separator, String center) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndCenterAndName(
            String separator, String center, String name) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndCenterAndClass_(
            String separator, String center, String class_) throws Exception;

    List<MemberDTO> selectMemberBySeparatorAndCenterAndPosition(
            String separator, String center, String position) throws Exception;
}
