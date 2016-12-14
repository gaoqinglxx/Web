package com.spmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spmvc.model.Auth_Role;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthRoleService;

@Controller
@RequestMapping("/authrole")
public class AuthRoleController {
	
	@Autowired
	private AuthRoleService authRoleService;
	
	
	@RequestMapping("/getAuthRole")
	@ResponseBody
	public DataGridResult getAuthRole(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer rows) {
		return authRoleService.getAuthRole(page, rows);
	}
	
	@RequestMapping("/getAuthRoleForSelect")
	@ResponseBody
	public List<Auth_Role> getAuthRoleForSelect(){
		return authRoleService.getAuthRoleForSelect();
	}
	
}
