package com.rara.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/noticeboard")
    public String noticeboard(Model model) {
        return "noticeboard";
    }
}
