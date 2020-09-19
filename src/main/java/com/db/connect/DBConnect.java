package com.db.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static Connection getconnection() {
		Connection con = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://10.218.110.141:3306/gsimessages?","root","NO");
			System.out.println("Database connected!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		getconnection();
	}
}