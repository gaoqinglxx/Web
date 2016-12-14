package com.spmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spmvc.model.Auth_User;
import com.spmvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @param request
	 * @param auth_User
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request,Auth_User auth_User){
		//查看用户名名和密码是否正确
		Auth_User user=userService.getUser(auth_User);
		if(user!=null){
			List<String> auth_function_url=userService.getAuthFunctionUrl(user);
			HttpSession session=request.getSession();
			session.setAttribute("auth_user", user);
			session.setAttribute("auth_function_url", auth_function_url);
			return "redirect:/index.jsp";
		}
		return "redirect:/login.html";
	}
}
