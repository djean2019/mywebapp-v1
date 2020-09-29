package com.project.darphe.mywebapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.darphe.mywebapp.model.UserLike;
import com.project.darphe.mywebapp.repository.UserLikeRepository;
import com.project.darphe.mywebapp.service.UserLikeService;

@Service
public class UserLikeServiceImpl implements UserLikeService {

	private UserLikeRepository likeRepository;
	
	public UserLikeServiceImpl(UserLikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	@Override
	public void save(UserLike like) {
		likeRepository.save(like);
	}

	@Override
	public List<UserLike> getAll() {
		return likeRepository.findAll();
	}

	@Override
	public UserLike getById() {
		return null;
	}

	@Override
	public void delete() {

	}

}
