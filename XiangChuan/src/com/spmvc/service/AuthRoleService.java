package com.spmvc.service;

import java.util.List;

import com.spmvc.model.Auth_Role;
import com.spmvc.model.DataGridResult;

public interface AuthRoleService {

	DataGridResult getAuthRole(Integer page, Integer rows);

	List<Auth_Role> getAuthRoleForSelect();

}
