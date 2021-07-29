package com.training;

import java.sql.Connection;
import java.sql.DriverManager;

public class UseConnection {
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user = "postgres";
	private static final String password = "ankesh";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionPool conn = new ConnectionPool(12);
		Connection a = conn.getConncetion();
		
		try {
			Connection b = DriverManager.getConnection(url, user, password);
			boolean x = conn.removeConncetion(a);
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("Total free connections: "+conn.getFreeConnectionCount());
		

	}

}
