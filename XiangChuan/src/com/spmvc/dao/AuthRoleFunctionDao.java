package com.spmvc.dao;

import java.util.List;
import java.util.Map;

public interface AuthRoleFunctionDao {

	void deleteGrantRoleFunction(Integer auth_role_id);

	void insertGrantRoleFunction(Map<String, Object> map);

	List<Map<String, Object>> getAuthRoleFunctionById(Integer auth_role_id);

}
