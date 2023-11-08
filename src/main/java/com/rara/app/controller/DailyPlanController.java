package com.rara.app.controller;

import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.DailyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class DailyPlanController {

    @Autowired
    DailyPlanService dailyPlanService;

    @GetMapping  // 접근 URL
    public String getDailyPlansAll(Model model) {
        try {
            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlansAll();
            // dailyPlanService를 호출. DailyPlan을 데이터베이스에서 검색
            // 이 정보를 DailyPlanDTO 객체의 목록 형태로 가져옴
            model.addAttribute("dailyPlans", dailyPlans);
            // model 객체를 사용. "dailyPlans"라는 속성 이름으로 dailyPlans 목록을 뷰에 전달
            // 이를 통해 뷰에서 이 데이터를 사용할 수 있음
            return "schedule";
            // schedule"라는 뷰 이름을 반환하여 해당 뷰를 렌더링
            // Thymeleaf 템플릿 엔진에서 "schedule.html" 템플릿을 찾아 클라이언트에게 반환하도록 요청
        } catch (Exception e) {
            return "error"; // 예외가 발생하면 "error" 뷰로 리디렉션
        }
    }

//    @GetMapping("/{id}")
//    public String getDailyPlanById(@PathVariable Long id, Model model) {
//        try {
//            DailyPlanDTO dailyPlan = dailyPlanService.selectDailyPlanById(id);
//            model.addAttribute("dailyPlan", dailyPlan);
//            return "schedule";
//        } catch (Exception e) {
//            return "error";
//        }
//    }

    @PostMapping
    // DB 저장
    public  String createDP(DailyPlanDTO dailyPlanDTO) {
        try {
            dailyPlanService.insertDailyPlan(dailyPlanDTO);
            return "redirect:schedule";
        } catch (Exception e) {
            return "redirect:schedule";
        }
    }

}
