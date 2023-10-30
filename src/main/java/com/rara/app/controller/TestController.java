package com.rara.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String testTest(Model model) {
		model.addAttribute("message", "Hello, Spring MVC!");
		return "test";
	}
	
	@GetMapping("/base")
	public String testBase(Model model) {
		model.addAttribute("message", "Hello, Spring MVC!");
		return "base";
	}
	
	@GetMapping("/child")
	public String testChild(Model model) {
		model.addAttribute("message", "Hello, Spring MVC!");
		return "child";
	}

	@GetMapping("/home")
	public String testHome(Model model) {
		return "home";
	}
}
