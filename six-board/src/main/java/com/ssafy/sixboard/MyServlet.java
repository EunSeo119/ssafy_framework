package com.ssafy.sixboard;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class MyServlet extends HttpServlet {
	
	public MyServlet() {
		System.out.println("MyServlet 생성됨...");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String location = config.getInitParameter("contextConfigLocation");
		System.out.println("location : " + location);
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("호출...");
	}
}
