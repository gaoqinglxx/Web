package com.gxa.live;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * �ض�����ת����ϰ
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
		//�޸�sessionֵ
		hs.setAttribute("test", "�޸ĺ��ֵ��,�˯������");
		response.sendRedirect("b.jsp");
	}

}
