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
		if(session == null) {//SessionΪ�գ�δ��¼�����û�ȥ��¼
			arg2.doFilter(hsq, hsp);
		}else {
			if(session.getAttribute("currentUser") != null) {//�û��ظ���¼����ֹ��������
				System.out.println("�ظ���¼");
				hsq.getRequestDispatcher("WEB-INF/Welcome.jsp").forward(hsq, hsp);
			}else {//�û�δ�ҵ����û�δ��¼��Session���ڣ������¼
				arg2.doFilter(hsq, hsp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
