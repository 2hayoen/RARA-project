package com.rara.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebTestController {

    @GetMapping("/")
    public String main_home(Model model) {
        return "index";
    }



//    @GetMapping("/signin")
//    public String login(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/login_22")
//    public String login_22(Model model) {
//        return "login_22";
//    }

    @GetMapping("/notice")
    public String notice(Model model) {
        return "noticeboard";
    }

    @GetMapping("/first")
    public String first_page(Model model) {
        return "First";
    }

    @GetMapping("/accept_create")
    public String notice_create(Model model) {
        return "accept_create";
    }

    @GetMapping("/accept_detail")
    public String accep_detail(Model model) {
        return "accept_detail";
    }

    @GetMapping("/accept_list")
    public String accep_list(Model model) {
        return "accept_list";
    }


}
