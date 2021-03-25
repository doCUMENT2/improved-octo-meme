package com.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)arg0;
		HttpServletResponse hsp = (HttpServletResponse)arg1;
		HttpSession session = hsq.getSession(false);
		if(session == null) {//Session为空，未登录，让用户去登录
			arg2.doFilter(hsq, hsp);
		}else {
			if(session.getAttribute("currentUser") != null) {//用户重复登录，禁止继续请求
				System.out.println("重复登录");
				hsq.getRequestDispatcher("WEB-INF/Welcome.jsp").forward(hsq, hsp);
			}else {//用户未找到，用户未登录或Session过期，允许登录
				arg2.doFilter(hsq, hsp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
