package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.Dao.UserRegisterDao;
import com.mydata.Dao.UserRegisterDaoImpl;
import com.mydata.model.User;

public class userRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userRegisterController() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//read the input
		
		String fn=request.getParameter("firstname");
		
		String ln=request.getParameter("lastname");
		
		String un=request.getParameter("username");
		
		String pwd=request.getParameter("password");
		
		User ur=new User(fn, ln, un, pwd);
		
		UserRegisterDao ud=new UserRegisterDaoImpl();
		
		int res=ud.saveUser(ur);
		

	
		if(res>0) {
			request.getRequestDispatcher("Login.html").forward(request, response);
		}else {
			out.print("Try Again");
			request.getRequestDispatcher("Register.html").include(request, response);
		}
	}

}
