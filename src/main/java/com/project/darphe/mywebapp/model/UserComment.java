package com.project.darphe.mywebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "the_comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="*Please Provide your name.")
	private String userName;
	@NotEmpty(message="*Please write your comment.")
	private String message;

}