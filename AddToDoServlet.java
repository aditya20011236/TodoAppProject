package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.Dao.TodoDao;
import com.mydata.Dao.TodoDaoImple;
import com.mydata.model.Todo;

public class AddToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToDoServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String targetdate = request.getParameter("targetdate");
		String Todostaus = request.getParameter("Todostaus");
		String tododescription = request.getParameter("tododescription");

		Todo d=new Todo(title, targetdate, Todostaus, tododescription);
		 TodoDao td=new TodoDaoImple();

		int res=td.saveTodo(d);

		if (res > 0) {
			request.getRequestDispatcher("Home.jsp").forward(request, response);

		} else {
			out.print("Pls Try Again");
			request.getRequestDispatcher("AddTodo.jsp").include(request, response);
		}

	}

}
