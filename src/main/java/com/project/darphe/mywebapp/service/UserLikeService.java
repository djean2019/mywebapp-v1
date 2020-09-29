package com.project.darphe.mywebapp.service;

import java.util.List;

import com.project.darphe.mywebapp.model.UserLike;

public interface UserLikeService {
	public void save(UserLike like);
	public List<UserLike> getAll();
	public UserLike getById();
	public void delete();
}
