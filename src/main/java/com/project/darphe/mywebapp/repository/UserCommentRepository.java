package com.project.darphe.mywebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.project.darphe.mywebapp.model.UserComment;

//@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {

}
