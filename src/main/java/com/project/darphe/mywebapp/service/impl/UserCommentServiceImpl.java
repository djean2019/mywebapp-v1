package com.project.darphe.mywebapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.darphe.mywebapp.model.UserComment;
import com.project.darphe.mywebapp.repository.UserCommentRepository;
import com.project.darphe.mywebapp.service.UserCommentService;

@Service
public class UserCommentServiceImpl implements UserCommentService {

	private UserCommentRepository commentRepository;
	
	@Autowired
	public UserCommentServiceImpl(UserCommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Override
	public void save(UserComment comment) {
		try{
			commentRepository.save(comment);
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserComment> getAll() {
		return commentRepository.findAll();
	}

	@Override
	public UserComment getById(int theId) {
		return null;
	}

	@Override
	public void deleteById(int theId) {

	}

}
