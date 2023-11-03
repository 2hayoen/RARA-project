package com.rara.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebTestController {

    @GetMapping("/base_test2")
    public String base_test2(Model model) {
        return "base2";
    }

    @GetMapping("/")
    public String main_home(Model model) {
        return "index";
    }

    @GetMapping("/base_test")
    public String base_test(Model model) {
        return "base_test";
    }


    @GetMapping("/classchild")
    public String child_class(Model model) {
        return "classchild";
    }

    @GetMapping("/notice_create")
    public String notice_create(Model model) {
        return "notice_create";
    }

    @GetMapping("/mypage")
    public String mypage(Model model) {
        return "mypage";
    }

    @GetMapping("/teacher")
    public String teacher_page(Model model) {
        return "teacher_page";
    }

    @GetMapping("/parents")
    public String parents_page(Model model) {
        return "parents_page";
    }

    @GetMapping("/schedule")
    public String schedule(Model model) {
        return "schedule";
    }

//    @GetMapping("/signup")
//    public String signup(Model model) {
//        return "signup";
//    }

//    @GetMapping("/signin")
//    public String signin(Model model) {
//        return "signin";
//    }


    @GetMapping("/writingboard")
    public String writingboard(Model model) {
        return "writingboard";
    }

    @GetMapping("/schedule_detail")
    public String scheduledetail(Model model) {
        return "scheduledetail";
    }

}
