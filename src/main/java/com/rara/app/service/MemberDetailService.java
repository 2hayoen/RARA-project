package com.rara.app.service;

import com.rara.app.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public MemberDTO loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return memberService.selectMemberByEmail(email);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
