package com.spmvc.dao;

import java.util.List;

import com.spmvc.model.Auth_Role;


public interface AuthRoleDao {

	List<Auth_Role> getAuthRole();

	List<Auth_Role> getAuthRoleForSelect();

}
