package com.spmvc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spmvc.model.Auth_User;
/**
 * 自定义拦截器
 * 1.需要在springmvc.xml文件中配置拦截器
 * 2.<mvc:intercepters/>
 * @author mabaoyun
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 当要请用系统中Controller,此方法先执行
	 * 如果true, 通过此方法进入到下一个拦截器或者Controller
	 * 如果false, 则进入不到Controller
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Auth_User auth_User=(Auth_User)session.getAttribute("auth_user");
		String url=request.getRequestURI();
		url=url.substring(url.lastIndexOf("/")+1);
		List<String> auth_function_url=(List<String>)session.getAttribute("auth_function_url");
		boolean flag=false;
		System.out.println("====preHandle====");
		
		if(auth_User==null || auth_function_url==null){
			response.sendRedirect("error.html");
			return false;
		}
		for(String s:auth_function_url){
			if(url.equals(s)){
				flag=true;
				break;
			}
		}
		if(auth_User!=null && flag){
			return true;
		}
		response.sendRedirect("error.html");
		return false;
	}

}
