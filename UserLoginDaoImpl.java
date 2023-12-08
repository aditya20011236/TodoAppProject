package com.mydata.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mydata.model.UserLogin;
import com.mydata.util.CreateConnection;

public class UserLoginDaoImpl implements userLoginDao {
 Connection con=CreateConnection.initConnection();
	public String validUser(UserLogin ul) {
		String res=null;
		
		String entusername=ul.getUsername();
		
		String entpassword=ul.getPassword();
		String dbpass=null;
		
	try {
		PreparedStatement ps=con.prepareStatement("select password from user where username=?");
		
		ps.setString(1, entusername);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			dbpass=rs.getString("password");
			System.out.println("dbpass"+dbpass);
			
		}
		con.close();
	}catch(Exception e) {
		System.out.println(e);
	}if(entpassword.equals(dbpass)) {
		res="valid";
	}else {
		res="invalid";
	}
		
		return res;
	}

}
