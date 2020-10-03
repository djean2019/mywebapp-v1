package com.project.darphe.mywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("darphejean")
public class FrenchController {

	@GetMapping("/acceuil")
	public String displayAccueil() {
		   
		return "darphejean/french-darphe-welcome";
	}
	 
	@GetMapping("/cv")
	public String displayResumel() {
		return "darphejean/french-darphe-resume";
	}
}
