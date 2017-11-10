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
	
	public List<User> findAll(Pageable pageable){
		Page<User> page = userDao.findAll(pageable);
		return page.getContent();
	}
	
	public List<User> findMaleList(String sex, Pageable page){
		return userDao.findMaleList(sex, page);
	}
	
	@Transactional(readOnly=false)
	public void insetUser(User user){
		userDao.save(user);
		System.out.println("保存后改用户的id为：-->"+user.getId());
	}
	
}
