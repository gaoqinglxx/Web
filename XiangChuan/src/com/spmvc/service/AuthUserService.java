package com.spmvc.service;

import com.spmvc.model.DataGridResult;

public interface AuthUserService {

	DataGridResult getAuthUser(Integer page, Integer rows);

}
