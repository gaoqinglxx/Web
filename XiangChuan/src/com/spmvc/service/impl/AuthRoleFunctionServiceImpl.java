package com.spmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.AuthRoleFunctionDao;
import com.spmvc.service.AuthRoleFunctionService;
@Service
public class AuthRoleFunctionServiceImpl implements AuthRoleFunctionService {
	
	@Autowired
	private AuthRoleFunctionDao authRoleFunctionDao;
	
	@Override
	public int updateAuthRoleFunction(Integer auth_role_id, String auth_function_id) {
//		Map<String,Object> map = new HashMap<>();
//		map.put("auth_role_id", auth_role_id);
//		map.put("auth_function_id", auth_function_id);
//		int i = authRoleFunctionDao.getIsGrantRoleFunction(map);
//		if (i > 0) { //权限已经分配, delete --> insert
//			authRoleFunctionDao.updateGrantRoleFunction(); //MyBatis的动态SQL
//		} else { //添加权限, insert
//			authRoleFunctionDao.insertGrantRoleFunction();
//		}
		try {
			authRoleFunctionDao.deleteGrantRoleFunction(auth_role_id);
			String[] ids = StringUtils.split(auth_function_id, ",");
			for (String id : ids) {
				Map<String, Object> map = new HashMap<>();
				map.put("auth_role_id", auth_role_id);
				map.put("auth_function_id", id);
				authRoleFunctionDao.insertGrantRoleFunction(map);
			}	
		}catch(Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public List<Map<String, Object>> getAuthRoleFunctionById(Integer auth_role_id) {
		
		return authRoleFunctionDao.getAuthRoleFunctionById(auth_role_id);
	}

}
