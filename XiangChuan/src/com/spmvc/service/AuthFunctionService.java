package com.spmvc.service;

import java.util.List;

import com.spmvc.easyui.result.TreeNodeResult;
import com.spmvc.model.Auth_Function;
import com.spmvc.model.DataGridResult;

public interface AuthFunctionService {

	List<TreeNodeResult> getAuthFunction();

	DataGridResult getAuthFunctionById(Integer auth_function_id, Integer page, Integer rows);

	List<Auth_Function> getAuthFunctionModel();

}
