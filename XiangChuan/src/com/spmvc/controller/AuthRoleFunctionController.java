package com.spmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spmvc.service.AuthRoleFunctionService;

@Controller
@RequestMapping("/authrolefunction")
public class AuthRoleFunctionController {
	@Autowired
	private AuthRoleFunctionService authRoleFunctionService;
	/**
	 * 更新角色,功能表
	 * @param auth_role_id
	 * @param auth_function_id
	 * @return
	 */
	@RequestMapping("/updateAuthRoleFunction")
	@ResponseBody
	public int updateAuthRoleFunction(Integer auth_role_id,String auth_function_id){
		
		return authRoleFunctionService.updateAuthRoleFunction(auth_role_id,auth_function_id);
	}
	
	@RequestMapping("/getAuthRoleFunctionById/{auth_role_id}")
	public ModelAndView getAuthRoleFunctionById(@PathVariable Integer auth_role_id){
		List<Map<String, Object>> list=authRoleFunctionService.getAuthRoleFunctionById(auth_role_id);
		return new ModelAndView("jsgl_grant_2","list_auth_function",list);
	}
	
}
