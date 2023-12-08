package com.mydata.Dao;

import java.util.List;

import com.mydata.model.Todo;

public interface TodoDao {
	
	public List<Todo>viewAllTodo();
	
	public int saveTodo(Todo d);
 
	public Todo viewTodoById(int i);
	
	public int deleteTodo(int i);
	
	public int updateTodo(int i,String t,String tdate,String tstatus,String Tdes);
}
