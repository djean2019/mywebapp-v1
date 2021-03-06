package com.project.darphe.mywebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.darphe.mywebapp.model.UserComment;
import com.project.darphe.mywebapp.model.UserLike;
import com.project.darphe.mywebapp.service.UserCommentService;
import com.project.darphe.mywebapp.service.UserLikeService;

@Controller
@RequestMapping("darphejean")
public class MyAppController {

	private UserCommentService commentService;
	private UserLikeService likeService;
	
	@Autowired
	public MyAppController(UserCommentService commentService, UserLikeService likeService) {
		this.commentService = commentService;
		this.likeService = likeService;
	}
	
	@GetMapping("/home")
	public String displayHome() {
		   
		return "darphejean/darphe-welcome";
	}
	
	@GetMapping("/resume")
	public String displayResume() {
		  
		return "darphejean/darphe-resume";
	}

	@GetMapping("/comments/list")
	public String displayComments(Model model) {
		try{
			List<UserComment> theComments = commentService.getAll();
			model.addAttribute("comments",theComments);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "darphejean/user-comment";
	}

	@GetMapping("/likes/list")
	public String displayLikes(Model model) {
		
		List<UserLike> theLikes=null;
		try{
			theLikes = likeService.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("likes",theLikes);
		
		return "darphejean/user-like";
	}

	@GetMapping("/likeform")
	public String showLikeForm(Model model) {
		
		UserLike userLike = new UserLike();
		model.addAttribute("like",userLike);
		
		return "darphejean/form-like";
	}
	
	@GetMapping("/commentform")
	public String showCommentForm(Model model) {
		
		UserComment userComment = new UserComment();
		model.addAttribute("comment",userComment);
		
		return "darphejean/form-comment";
	}

	@PostMapping("/savelike")
	public String saveLike(@ModelAttribute("like") UserLike userLike) {
		
		try{
			likeService.save(userLike);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/darphejean/likes/list";
	}

	@PostMapping("/savecomment")
	public String saveComment(@ModelAttribute("comment") UserComment userComment) {
		
		try{
			commentService.save(userComment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/darphejean/comments/list";
	}
}
