package com.gxa.live;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 重定向与转发练习
 * @author mabaoyun
 *
 */
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs= request.getSession();
		System.out.println(hs.getAttribute("test"));
		//修改session值
		hs.setAttribute("test", "修改后的值啊,瞌睡来流了");
		response.sendRedirect("b.jsp");
	}

}
