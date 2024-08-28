package com.project.darphe.mywebapp.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.darphe.mywebapp.model.UserComment;
import com.project.darphe.mywebapp.repository.UserCommentRepository;
import com.project.darphe.mywebapp.service.UserCommentService;

@Service
@RequiredArgsConstructor
public class UserCommentServiceImpl implements UserCommentService {

	private final UserCommentRepository commentRepository;
	
	@Override
	public void save(UserComment comment) {
		commentRepository.save(comment);
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
