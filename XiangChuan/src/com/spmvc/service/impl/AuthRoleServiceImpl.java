package com.spmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spmvc.dao.AuthRoleDao;
import com.spmvc.model.Auth_Role;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthRoleService;
@Service
public class AuthRoleServiceImpl implements AuthRoleService {
	@Autowired
	private AuthRoleDao authRoleDao;
	
	@Override
	public DataGridResult getAuthRole(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Auth_Role> list = authRoleDao.getAuthRole();
		PageInfo<Auth_Role> pageInfo = new PageInfo<>(list);
		DataGridResult dataGridResult = new DataGridResult(pageInfo.getTotal(), list);
		return dataGridResult;
	}

	@Override
	public List<Auth_Role> getAuthRoleForSelect() {
		return authRoleDao.getAuthRole();
	}

}
