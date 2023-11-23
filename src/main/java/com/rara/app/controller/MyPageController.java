package com.rara.app.controller;

import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.dto.MemberDTO;
import com.rara.app.service.DailyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    DailyPlanService dailyPlanService;

    @GetMapping
    public String showMyPage() {
        return "myPage";
    }

    @GetMapping("/myActList")
    public String getDailyPlans(Model model) {

        try {
            MemberDTO member = (MemberDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long mId = member.getId();

            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlanByMId(mId);
            model.addAttribute("dailyPlans", dailyPlans);
            return "Teacher_Act_list";
        } catch (Exception e) {
            return "error";
        }
    }
}
