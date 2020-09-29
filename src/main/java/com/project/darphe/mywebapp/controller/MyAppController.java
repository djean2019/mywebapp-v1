package com.project.darphe.mywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("darphejean")
public class MyAppController {

	@GetMapping("/home")
	public String displayHome() {
		  
		return "darphejean/darphe-welcome";
	}
	
	@GetMapping("/resume")
	public String displayResume() {
		  
		return "darphejean/darphe-resume";
	}
}
