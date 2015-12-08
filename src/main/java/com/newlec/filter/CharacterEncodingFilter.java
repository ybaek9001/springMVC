package com.newlec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	
	private String encoding;
	public FilterConfig filterConfig;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���� ����");
		
		//web.xml�� �����س��� encoding���� ��������
		request.setCharacterEncoding(encoding);
		
		//filter���� �� ���� ���������� request�� response�� �Ѱ������ν� �ùٸ��� �������� ���̵��� ��.
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
		encoding = filterConfig.getInitParameter("encoding");
		
	}
	
	@Override
	public void destroy() {
		
	}
}
