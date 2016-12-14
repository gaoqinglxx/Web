package com.spmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.UserDao;
import com.spmvc.model.Auth_User;
import com.spmvc.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public Auth_User getUser(Auth_User auth_User) {
		
		return userDao.getUser(auth_User);
	}

	@Override
	public List<String> getAuthFunctionUrl(Auth_User user) {
		
		return userDao.getAuthFunctionUrl(user);
	}

}
