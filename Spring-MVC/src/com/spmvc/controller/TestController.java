package com.spmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spmvc.model.Student;
import com.spmvc.model.User;
import com.spmvc.service.StudentService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class TestController {
	
	@Autowired
	private StudentService studentService;
	/**
	 * 测试路径
	 * @return
	 */
	@RequestMapping("testLogin01")
	public String testLogin01(){
		return "m01";
	}
	/**
	 * 表单提交
	 * @param user
	 * @return
	 */
	@RequestMapping("Login02")//@ModelAttribute("user")可以省略,封装成javaBean,不写的话,表单中提交的参数名对应javabean中的属性
	public String testLogin02(@ModelAttribute("user")User user){
		System.out.println(user);
		return "m02";
	}
	
	@RequestMapping("Login03")
	public String test02(HttpServletRequest request,HttpServletResponse response){
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("name==="+name+"      password=="+password+"     response=="+response.toString());
		return "m02";
	}
	/**
	 * reset使用
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/tt03/{id}/{name}")
	public String testLogin03(@PathVariable("id") String id,@PathVariable("name") String name){
		
		System.out.println("id=="+id+"     name=="+name);
		return "m03";
	}
	
	/**
	 * 将控制器的数据返回到视图层
	 */
	@RequestMapping("test04")
	public ModelAndView test04(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("m04");
		//单一值
		mav.addObject("name","张三");
		//list
		List<String> list=new ArrayList<>();
		list.add("成都");
		list.add("南充");
		mav.addObject("list",list);
		//model
		User user=new User("李四","123456");
		mav.addObject("user",user);
		//map
		Map<String, String> map=new HashMap<>();
		map.put("name", "赵六");
		map.put("age", "23");
		map.put("addr", "成都");
		mav.addObject("map",map);
		return mav;
	}
	
	@RequestMapping("test4")
	public ModelAndView test4(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("name", "张三啊");
		
		return new ModelAndView("m04");
		
	}
	/**
	 * json格式数据
	 * @return
	 */
	@RequestMapping("/test05")
	@ResponseBody
	public User test05(){
		
		User user=new User("zhangsan","123");
		return user;
	}
	
	@RequestMapping("/test06")
	@ResponseBody
	public Map<String, Object> test06(){
		
		Map<String, Object> map=new HashMap<>();
		map.put("name", "张三");
		map.put("age", 23);
		return map;
	}
	
	@RequestMapping("/test07")
	@ResponseBody
	public List<Map<String, Object>> test07(){
		
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map1=new HashMap<>();
		map1.put("name", "张三");
		map1.put("age", 23);
		Map<String, Object> map2=new HashMap<>();
		map2.put("name", "李四");
		map2.put("age", 24);
		list.add(map1);
		list.add(map2);
		return list;
	}
	
	@RequestMapping("/test08")
	@ResponseBody
	public List<User> test08(){
		
		List<User> list=new ArrayList<>();
		User user1=new User("张三","111");
		User user2=new User("李四","111");
		User user3=new User("王五","111");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
	
	@RequestMapping("/test09")
	@ResponseBody
	public List<Student> test09(){
		
		return studentService.getStudent();
	}
}
