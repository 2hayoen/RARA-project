package com.rara.app.controller;

import com.rara.app.dto.BoardDTO;
import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.dto.DailyRecordDTO;
import com.rara.app.dto.MemberDTO;
import com.rara.app.service.BoardService;
import com.rara.app.service.DailyPlanService;
import com.rara.app.service.DailyRecordService;
import com.rara.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/test")
    public String testTest(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "test/test";
    }

    @GetMapping("/base")
    public String testBase(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "test/base";
    }

    @GetMapping("/child")
    public String testChild(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "test/child";
    }

    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public String getMembersAll(Model model) {
        try {
            List<MemberDTO> members = memberService.selectMembersAll();
            model.addAttribute("members", members);
            return "test/members";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/member/{id}")
    public String getMemberById(@PathVariable Long id, Model model) {
        try {
            MemberDTO member = memberService.selectMemberById(id);
            model.addAttribute("member", member);
            return "test/member";
        } catch (Exception e) {
            return "error";
        }
    }

    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoardsAll(Model model) {
        try {
            List<BoardDTO> boards = boardService.selectBoardsAll();
            model.addAttribute("boards", boards);
            return "test/boards";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/board/{id}")
    public String getBoardById(@PathVariable Long id, Model model) {
        try {
            BoardDTO board = boardService.selectBoardById(id);
            model.addAttribute("board", board);
            return "test/board";
        } catch (Exception e) {
            return "error";
        }
    }

    @Autowired
    DailyPlanService dailyPlanService;

    @GetMapping("/dailyplan")
    public String getDailyPlansAll(Model model) {
        try {
            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlansAll();
            model.addAttribute("dailyPlans", dailyPlans);
            return "test/dailyPlans";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/dailyplan/{id}")
    public String getDailyPlanById(@PathVariable Long id, Model model) {
        try {
            DailyPlanDTO dailyPlan = dailyPlanService.selectDailyPlanById(id);
            model.addAttribute("dailyPlan", dailyPlan);
            return "test/dailyPlan";
        } catch (Exception e) {
            return "error";
        }
    }

    @Autowired
    DailyRecordService dailyRecordService;

    @GetMapping("/dailyrecord")
    public String getDailyRecordsAll(Model model) {
        try {
            List<DailyRecordDTO> dailyRecords = dailyRecordService.selectDailyRecordsAll();
            model.addAttribute("dailyRecords", dailyRecords);
            return "test/dailyRecords";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/dailyrecord/{id}")
    public String getDailyRecordById(@PathVariable Long id, Model model) {
        try {
            DailyRecordDTO dailyRecord = dailyRecordService.selectDailyRecordById(id);
            model.addAttribute("dailyRecord", dailyRecord);
            return "test/dailyRecord";
        } catch (Exception e) {
            return "error";
        }
    }

}
