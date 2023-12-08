package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.Dao.UserLoginDaoImpl;
import com.mydata.Dao.userLoginDao;
import com.mydata.model.UserLogin;

public class userloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userloginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("html/text");
		PrintWriter out = response.getWriter();

		String u = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("username " + u);
		System.out.println("username " + pass);

		UserLogin ul = new UserLogin(u, pass);
		
		userLoginDao dao=new UserLoginDaoImpl();
		
		String output=dao.validUser(ul);
		
		if(output.equalsIgnoreCase("valid")) {
		    response.sendRedirect("Home.jsp");
			
		}else {
			out.print("<b>invalid username or password</b>");
			request.getRequestDispatcher("Login.html").include(request, response);
		}

	}

}
