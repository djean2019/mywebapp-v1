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
public class FrenchController {

	private UserCommentService commentService;
	private UserLikeService likeService;
	
	@Autowired
	public FrenchController(UserCommentService commentService, UserLikeService likeService) {
		this.commentService = commentService;
		this.likeService = likeService;
	}
	
	@GetMapping("/accueil")
	public String displayAccueil() {
		   
		return "darphejean/french-darphe-welcome";
	}
	 
	@GetMapping("/cv")
	public String displayResumel() {
		return "darphejean/french-darphe-resume";
	}
	
	@GetMapping("/commentaires/list")
	public String displayComments(Model model) {
		try{
			List<UserComment> theComments = commentService.getAll();
			model.addAttribute("comments",theComments);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "darphejean/french-user-comment";
	}

	@GetMapping("/jaimes/list")
	public String displayLikes(Model model) {
		
		List<UserLike> theLikes=null;
		try{
			theLikes = likeService.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("likes",theLikes);
		
		return "darphejean/french-user-like";
	}

	@GetMapping("/formjaime")
	public String showLikeForm(Model model) {
		
		UserLike userLike = new UserLike();
		model.addAttribute("like",userLike);
		   
		return "darphejean/french-form-like";
	}
	
	@GetMapping("/formcommentaire")
	public String showCommentForm(Model model) {
		
		UserComment userComment = new UserComment();
		model.addAttribute("comment",userComment);
		
		return "darphejean/french-form-comment";
	}

	@PostMapping("/savejaime")
	public String saveLike(@ModelAttribute("like") UserLike userLike) {
		
		try{
			likeService.save(userLike);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/darphejean/jaimes/list";
	}

	@PostMapping("/savecommentaire")
	public String saveComment(@ModelAttribute("comment") UserComment userComment) {
		
		try{
			commentService.save(userComment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/darphejean/commentaires/list";
	}
}
