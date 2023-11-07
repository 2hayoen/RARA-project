package com.rara.app.controller;

import com.rara.app.dto.MemberDTO;
import com.rara.app.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberSecurityController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/personal")
    public String home(Model model) { // 인증된 사용자의 정보를 보여줌

        MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(member);
        System.out.println(SecurityContextHolder.getContext());
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        Long id = member.getId();

        try {
            MemberDTO memberDTO = memberService.selectMemberById(id);
            memberDTO.setPwd(memberService.passwordEncoder().encode(memberDTO.getPwd())); // password는 보이지 않도록 null로 설정
            model.addAttribute("users", memberDTO);
            return "home1";
        } catch (Exception e) {
            model.addAttribute("msg", "Member personal Error!");
            return "error";
        }

    }

    @GetMapping("/userList")
    public String getMembers(Model model) { // User 테이블의 전체 정보를 보여줌
        try {
            List<MemberDTO> members = memberService.selectMembersAll();
            model.addAttribute("list", members);
            return "userList";
        } catch (Exception e) {
            model.addAttribute("msg", "Member MemberList Error!");
            return "error";
        }

    }

    @GetMapping("/login")
    public String loginPage() { // 로그인되지 않은 상태이면 로그인 페이지를, 로그인된 상태이면 home 페이지를 보여줌
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "login";
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupPage() {  // 회원 가입 페이지
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "signup";
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO) { // 회원 가입
        try {
            memberService.insertMember(memberDTO);
        } catch (Exception e) {
//            model.addAttribute("msg", "Member signup Error!");
            return "error";
        }
        return "redirect:/login";
    }

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
        MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = member.getId();

        try {
            MemberDTO memberDTO = memberService.selectMemberById(id);
            model.addAttribute("user", memberDTO);
            return "edit";
        } catch (Exception e) {
            model.addAttribute("msg", "Member edit page Error!");
            return "error";
        }

    }

    @PostMapping("/update")
    public String edit(MemberDTO memberDTO, Model model) { // 회원 정보 수정
        MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = member.getId();
        memberDTO.setId(id);
        try {
            memberService.updateMember(memberDTO);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("msg", "Member edit Error!");
            return "error";
        }

    }

    @PostMapping("/delete")
    public String withdraw(HttpSession session, Model model) { // 회원 탈퇴
        MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = member.getId();

        try {
            if (id != null) {
                memberService.deleteMember(id);
            }
            SecurityContextHolder.clearContext(); // SecurityContextHolder에 남아있는 token 삭제
            return "redirect:/logout";
        } catch (Exception e) {
            model.addAttribute("msg", "Member delete Error!");
            return "error";
        }

    }

}