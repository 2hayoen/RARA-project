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
@RequestMapping("/api/testAll")
public class TestAllController {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @Autowired
    DailyPlanService dailyPlanService;

    @Autowired
    DailyRecordService dailyRecordService;

    @GetMapping("/")
    public String testAllMyBatis(Model model) {
        
        return "test/testAll";
    }
}
