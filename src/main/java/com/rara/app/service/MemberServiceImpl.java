package com.rara.app.service;

import com.rara.app.dto.MemberDTO;
import com.rara.app.model.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

    @Override
    public void insertMember(MemberDTO memberDTO) throws Exception {
        if (!memberDTO.getName().equals("") && !memberDTO.getEmail().equals("")) {
            // password는 암호화해서 DB에 저장
            memberDTO.setPwd(passwordEncoder.encode(memberDTO.getPwd()));

            memberMapper.insertMember(memberDTO);
        }
    }

    @Override
    public void deleteMember(Long id) throws Exception {
        memberMapper.deleteMember(id);
    }


    @Override
    public void updateMember(MemberDTO memberDTO) throws Exception {
        memberDTO.setPwd(passwordEncoder.encode(memberDTO.getPwd()));
        memberMapper.updateMember(memberDTO);
    }


    @Override
    public void updateMemberSetEmailOrPwdOrNameOrPhNumOrAddr(
            Map<String, Object> params) throws Exception {
        if (params.get("pwd") != null) {
            params.put("pwd", passwordEncoder.encode((String) params.get("pwd")));
        }
        memberMapper.updateMemberSetEmailOrPwdOrNameOrPhNumOrAddr(params);
    }


    @Override
    public List<MemberDTO> selectMembersAll() throws Exception {
        Map<String, Object> params = new HashMap<>();

        memberMapper.selectMembersAll(params);

        return (List<MemberDTO>) params.get("cursor");
    }


    @Override
    public MemberDTO selectMemberById(Long id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        memberMapper.selectMemberById(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }


    @Override
    public MemberDTO selectMemberByEmail(String email) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        memberMapper.selectMemberByEmail(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }


    @Override
    public List<MemberDTO> selectMemberBySeparatorAndNameOrPhNumOrMId(
            Map<String, Object> params) throws Exception {

        memberMapper.selectMemberBySeparatorAndNameOrPhNumOrMId(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }


    @Override
    public List<MemberDTO> selectMemberBySeparatorAndCenterAndNameOrClass_OrPosition(
            Map<String, Object> params) throws Exception {

        memberMapper.selectMemberBySeparatorAndCenterAndNameOrClass_OrPosition(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

}
