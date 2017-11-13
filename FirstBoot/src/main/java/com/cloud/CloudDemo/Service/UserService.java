package com.cloud.CloudDemo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.CloudDemo.dao.UserDao;
import com.cloud.CloudDemo.model.User;



@Service
@Transactional(rollbackFor=Exception.class,readOnly=true)
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public Page<User> findAll(Pageable pageable){
		Page<User> page = userDao.findAll(pageable);
		return page;
	}
	
	public List<User> findMaleList(String sex){
		return userDao.findMaleList(sex);
	}
	
	@Transactional(readOnly=false)
	public void insetUser(User user){
		userDao.save(user);
	}
	
	public User findByUsername(String name){
		return userDao.findByUsername(name);
		
	}
	
}
