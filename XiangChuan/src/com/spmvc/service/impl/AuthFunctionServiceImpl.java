package com.spmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spmvc.dao.AuthFunctionDao;
import com.spmvc.easyui.result.TreeNodeResult;
import com.spmvc.model.Auth_Function;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthFunctionService;
@Service
public class AuthFunctionServiceImpl implements AuthFunctionService {
	@Autowired
	private AuthFunctionDao authFunctionDao;

	@Override
	public List<TreeNodeResult> getAuthFunction() {
		List<TreeNodeResult> list=new ArrayList<>();
		TreeNodeResult root=new TreeNodeResult(0,"系统管理","open",null);
		list.add(root);
		
		List<Auth_Function> list_auth_function=authFunctionDao.getAuthFunction();
		for(Auth_Function auth_function:list_auth_function){
			TreeNodeResult node=new TreeNodeResult(auth_function.getAuth_function_id(),auth_function.getAuth_function_name(),"closed",0);
			list.add(node);
		}
		return list;
	}
	@Override
	public DataGridResult getAuthFunctionById(Integer auth_function_id, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Auth_Function> list = authFunctionDao.getAuthFunctionById(auth_function_id);
		PageInfo<Auth_Function> pageInfo = new PageInfo<>(list);
		DataGridResult dataGridResult = new DataGridResult(pageInfo.getTotal(), list);
		return dataGridResult;
	}
	
	@Override
	public List<Auth_Function> getAuthFunctionModel() {
		
		return authFunctionDao.getAuthFunction();
	}
}
