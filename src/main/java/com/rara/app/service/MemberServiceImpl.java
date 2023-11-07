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
    public void deleteMember(long id) throws Exception {
        memberMapper.deleteMember(id);
    }


    @Override
    public void updateMember(MemberDTO memberDTO) throws Exception {
        memberDTO.setPwd(passwordEncoder.encode(memberDTO.getPwd()));
        memberMapper.updateMember(memberDTO);
    }

    @Override
    public void updateMemberSetEmail(long id, String email) throws Exception {
        memberMapper.updateMemberSetEmail(id, email);
    }

    @Override
    public void updateMemberSetPwd(long id, String pwd) throws Exception {
        memberMapper.updateMemberSetPwd(id, passwordEncoder.encode(pwd));
    }

    @Override
    public void updateMemberSetName(long id, String name) throws Exception {
        memberMapper.updateMemberSetName(id, name);
    }

    @Override
    public void updateMemberSetPhNum(long id, String phNum) throws Exception {
        memberMapper.updateMemberSetPhNum(id, phNum);
    }

    @Override
    public void updateMemberSetAddr(long id, String addr) throws Exception {
        memberMapper.updateMemberSetAddr(id, addr);
    }

    @Override
    public List<MemberDTO> selectMembersAll() throws Exception {
        Map<String, Object> params = new HashMap<>();

        memberMapper.selectMembersAll(params);

        return (List<MemberDTO>) params.get("cursor");
    }


    @Override
    public MemberDTO selectMemberById(long id) throws Exception {
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
    public List<MemberDTO> selectMemberBySeparator(String separator) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        memberMapper.selectMemberBySeparator(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndName(String separator, String name) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("name", name);
        memberMapper.selectMemberBySeparatorAndName(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndPhNum(String separator, String phNum) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("phNum", phNum);
        memberMapper.selectMemberBySeparatorAndPhNum(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndMId(String separator, long mId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("mId", mId);
        memberMapper.selectMemberBySeparatorAndMId(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndCenter(String separator, String center) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("center", center);
        memberMapper.selectMemberBySeparatorAndCenter(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndCenterAndName(
            String separator, String center, String name) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("center", center);
        params.put("name", name);
        memberMapper.selectMemberBySeparatorAndCenterAndName(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndCenterAndClass_(
            String separator, String center, String class_) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("center", center);
        params.put("class_", class_);
        memberMapper.selectMemberBySeparatorAndCenterAndClass_(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<MemberDTO> selectMemberBySeparatorAndCenterAndPosition(
            String separator, String center, String position) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("separator", separator);
        params.put("center", center);
        params.put("position", position);
        memberMapper.selectMemberBySeparatorAndCenterAndPosition(params);

        List<MemberDTO> results = (List<MemberDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

}
