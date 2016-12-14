package com.spmvc.service;

import java.util.List;
import java.util.Map;

public interface AuthRoleFunctionService {

	int updateAuthRoleFunction(Integer auth_role_id, String auth_function_id);

	List<Map<String, Object>> getAuthRoleFunctionById(Integer auth_role_id);

}
