package com.gxa.live;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session¡∑œ∞
 */
public class SessionServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ω¯»Î¡Àsession");
		HttpSession session=request.getSession();
		session.setAttribute("test", "hhhhhhhhhhhhhhhhhhhhhhhhhh");
		//response.sendRedirect("b.jsp");
		request.getRequestDispatcher("b.jsp").forward(request, response);
	}

}
