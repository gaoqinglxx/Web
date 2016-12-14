package com.spmvc.dao;

import java.util.List;

import com.spmvc.model.Auth_User;

public interface UserDao {

	Auth_User getUser(Auth_User auth_User);

	List<String> getAuthFunctionUrl(Auth_User user);

}
