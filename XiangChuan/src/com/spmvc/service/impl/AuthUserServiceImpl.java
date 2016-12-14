package com.spmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spmvc.dao.AuthUserDao;
import com.spmvc.model.Auth_User;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthUserService;

@Service
public class AuthUserServiceImpl implements AuthUserService {
	@Autowired
	private AuthUserDao authUserDao;
	
	@Override
	public DataGridResult getAuthUser(Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		List<Auth_User> list=authUserDao.getAuthUser();
		PageInfo<Auth_User> pageInfo=new PageInfo<>(list);
		DataGridResult dataGridResult=new DataGridResult(pageInfo.getTotal(),list);
		return dataGridResult;
	}

}
