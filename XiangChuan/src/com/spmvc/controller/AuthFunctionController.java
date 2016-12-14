package com.spmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spmvc.easyui.result.TreeNodeResult;
import com.spmvc.model.Auth_Function;
import com.spmvc.model.DataGridResult;
import com.spmvc.service.AuthFunctionService;

@RequestMapping("/authfunction")
@Controller
public class AuthFunctionController {
	@Autowired
	private AuthFunctionService authFunctionService;
	/**
	 * 查询全部的功能模块
	 * @return
	 */
	@RequestMapping("/getAuthFunction")
	@ResponseBody
	public List<TreeNodeResult> getAuthFunction(){
		return authFunctionService.getAuthFunction();
	}
	
	/**
	 * 通过auth_function的id查询
	 * @param auth_function_id
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getAuthFunctionById/{auth_function_id}")//restful风格
	@ResponseBody                                        
	public DataGridResult getAuthFunctionById(@PathVariable Integer auth_function_id, @RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer rows) {
		return authFunctionService.getAuthFunctionById(auth_function_id, page, rows);
	}
	/**
	 * 得到AuthFunction
	 * @return
	 */
	@RequestMapping("/getAuthFunctionModel")
	public ModelAndView getAuthFunctionModel(){
		
		List<Auth_Function> list=authFunctionService.getAuthFunctionModel();
		return new ModelAndView("jsgl_grant","list_auth_function",list);
		
	}
	
}
