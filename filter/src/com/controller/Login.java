package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("pw");
		System.out.println("用户名:"+username+"\n密码:"+password);
		if(username.equals("王宁") && password.equals("123")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("currentUser",username);
			request.getRequestDispatcher("WEB-INF/Welcome.jsp").forward(request, response);
		}else {
			System.out.println("密码或用户名错误");
			response.sendRedirect("error.jsp");
		}
	}
}
