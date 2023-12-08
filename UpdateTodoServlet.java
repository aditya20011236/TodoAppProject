package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.Dao.TodoDao;
import com.mydata.Dao.TodoDaoImple;


public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int i=Integer.parseInt(request.getParameter("id"));
		
		String title=request.getParameter("title");
		String targetdate=request.getParameter("targetdate");
		
		String Todostaus=request.getParameter("Todostaus");
		
		String tododescription=request.getParameter("tododescription");
		
		TodoDao td=new TodoDaoImple();
		
		int res=td.updateTodo(i, title, targetdate, Todostaus, tododescription);
		
		if(res>0) {
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			
		}else {
			out.print("pls try again");
			request.getRequestDispatcher("updateTodo.jsp").include(request, response);
		}
		
	}

}
