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
		System.out.println("�û���:"+username+"\n����:"+password);
		if(username.equals("����") && password.equals("123")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("currentUser",username);
			request.getRequestDispatcher("WEB-INF/Welcome.jsp").forward(request, response);
		}else {
			System.out.println("������û�������");
			response.sendRedirect("error.jsp");
		}
	}
}
