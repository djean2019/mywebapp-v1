package com.project.darphe.mywebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.darphe.mywebapp.model.UserComment;
import com.project.darphe.mywebapp.service.UserCommentService;

@Controller
@RequestMapping("darphejean")
public class MyAppController {

	private UserCommentService commentService;
	
	@Autowired
	public MyAppController(UserCommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/home")
	public String displayHome() {
		  
		return "darphejean/darphe-welcome";
	}
	
	@GetMapping("/resume")
	public String displayResume() {
		  
		return "darphejean/darphe-resume";
	}
	
	@GetMapping("/userComments")
	public String displayComments(Model model) {
		
		List<UserComment> theComments = commentService.getAll();
		model.addAttribute("comments",theComments);
		
		return "darphejean/user-comments";
	}
}
