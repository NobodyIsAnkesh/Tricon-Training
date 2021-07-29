package com.training;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RotateImage {
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user = "postgres";
	private static final String password = "ankesh";

	public static void main(String[] args) throws FileNotFoundException {
		
		try{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt=conn.createStatement();
			
			String tableSql = "CREATE TABLE Images(name varchar, image bytea)";
			stmt.execute(tableSql);
			File file = new File("D:/147056.jpg");
			FileInputStream fis = new FileInputStream(file);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Images VALUES (?, ?)");
			ps.setString(1, file.getName());
			ps.setBinaryStream(2, fis, (int)file.length());
			ps.executeUpdate();
			
			
			
		}
		catch(SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());	
		}

	}

}
