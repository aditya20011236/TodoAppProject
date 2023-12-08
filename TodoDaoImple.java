package com.mydata.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mydata.model.Todo;
import com.mydata.util.CreateConnection;
import com.mysql.cj.protocol.Resultset;

public class TodoDaoImple implements TodoDao {

	Connection con = CreateConnection.initConnection();

	public List<Todo> viewAllTodo() {
		List<Todo> all = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Todo");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Todo d = new Todo();
				d.setId(rs.getInt(1));
				d.setTitle(rs.getString(2));
				d.setTargetdate(rs.getString(3));
				d.setTodostaus(rs.getString(4));
				all.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return all;
	}

	public int saveTodo(Todo d) {
		int x = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into Todo(title,targetdate,Todostaus,tododescription) values(?,?,?,?)");
			ps.setString(1, d.getTitle());
			ps.setString(2, d.getTargetdate());
			ps.setString(3, d.getTodostaus());
			ps.setString(4, d.getTododescription());

			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public Todo viewTodoById(int i) {
		Todo d = new Todo();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Todo where id=?");

			ps.setInt(1, i);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d.setId(rs.getInt(1));
				d.setTitle(rs.getString(2));
				d.setTargetdate(rs.getString(3));
				d.setTodostaus(rs.getString(4));
				d.setTododescription(rs.getString(5));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}

	public int deleteTodo(int i) {
		int x = 0;
		try {

			PreparedStatement ps = con.prepareStatement("delete from Todo where id=?");
			ps.setInt(1, i);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}

	public int updateTodo(int i, String t, String tdate, String tstatus, String Tdes) {
		int x = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update Todo SET title=?, targetdate=?, Todostaus=?, tododescription=? WHERE id = ?");
			ps.setString(1, t);
			ps.setString(2, tdate);
			ps.setString(3, tstatus);
			ps.setString(4, Tdes);
			ps.setInt(5, i);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

}
