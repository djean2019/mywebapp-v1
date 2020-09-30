package com.project.darphe.mywebapp.service;

import java.sql.SQLException;
import java.util.List;

import com.project.darphe.mywebapp.model.UserComment;

public interface UserCommentService {
	public void save(UserComment comment); 
	public List<UserComment> getAll() throws SQLException;
	public UserComment getById(int theId);
	public void deleteById(int theId);
}
