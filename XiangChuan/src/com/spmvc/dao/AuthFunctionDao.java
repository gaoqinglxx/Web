package com.spmvc.dao;

import java.util.List;

import com.spmvc.model.Auth_Function;

public interface AuthFunctionDao {

	List<Auth_Function> getAuthFunction();

	List<Auth_Function> getAuthFunctionById(Integer auth_function_id);

}
