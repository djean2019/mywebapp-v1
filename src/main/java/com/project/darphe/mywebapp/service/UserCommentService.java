package com.project.darphe.mywebapp.service;

import java.util.List;

import com.project.darphe.mywebapp.model.UserComment;

public interface UserCommentService {
	public void save(UserComment comment); 
	public List<UserComment> getAll();
	public UserComment getById(int theId);
	public void deleteById(int theId);
}
