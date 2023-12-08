package com.mydata.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mydata.model.User;
import com.mydata.util.CreateConnection;

public class UserRegisterDaoImpl implements UserRegisterDao {
	Connection con = CreateConnection.initConnection();

	public int saveUser(User u) {
		int x = 0;

		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)");
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());

			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

}
