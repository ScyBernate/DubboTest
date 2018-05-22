package com.example.feign1.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User implements Serializable{
	
	private static final long serialVersionUID = 6862316738890077206L;

	private Long id;

	private String name;

	private String password;

	private String username;

	private String sex;

	private String email;

	public User(Long id, String name, String password, String username, String sex, String email){
		this.id = id;
		this.name = name;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.email = email;
	}


}