package com.briup.apps.app02.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.briup.apps.app02.bean.Result;
import com.briup.apps.app02.service.TemplateService;
import org.springframework.stereotype.Service;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {


	private UserMapper userMapper;


	TemplateService templateService;
	private long User;

	@Override
	public List<User> findAll() throws Exception {

		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setName("Alex");
		user.setBirth("fourth of December");
		user.setGender("male");
		user.setId((long) 123456789);
		list.add(user);
		return list;
	}

	@Override
	public User findById(long id) throws Exception {
//		return userMapper.findById(id);

		return findUserFromDemo2(123456789) ;

	}

	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
	}


	public User findUserFromDemo1(long id) {
		Result result = templateService.callGet(id);

		User user = new User();
		user.setName("Ezio");
		user.setBirth("fourth of November");
		user.setGender("female");
		user.setId((long) 987654321);
		return user;
	}

	@Override
	public User findUserFromDemo2(long id) {
		Result result = templateService.callGet(id);

		User user = new User();
		user.setName("Alex");
		user.setBirth("fourth of December");
		user.setGender("male");
		user.setId((long) 123456789);
		return user;
	}

}
