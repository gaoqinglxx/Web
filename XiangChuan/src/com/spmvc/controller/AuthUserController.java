package com.spmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthUserService;


@Controller
@RequestMapping("/authuser")
public class AuthUserController {
	@Autowired
	private AuthUserService authUserService;
	
	/**
	 * 得到全部的用户
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getAuthUser")
	@ResponseBody
	public DataGridResult getAuthUser(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows){
		return authUserService.getAuthUser(page,rows);
	}
	
}
