package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	List<Connection> allConnection = new ArrayList<Connection>();
	List<Connection> freeConncetion = new ArrayList<Connection>();
	List<Connection> activeConnection = new ArrayList<Connection>();
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user = "postgres";
	private static final String password = "ankesh";
	private int last = 0;

	ConnectionPool(int n) {

		last = n - 1;
		for (int i = 0; i < n; i++) {
			try {
				Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
				this.allConnection.add(conn);
				this.freeConncetion.add(conn);
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		}
	}

	public Connection getConncetion() {

		Connection temp = freeConncetion.get(last);
		freeConncetion.remove(last);
		activeConnection.add(temp);
		last--;
//		System.out.println("After getConnection():" + (last+1));

		return temp;
	}

	public boolean removeConncetion(Connection temp) {
		int activeSize = activeConnection.size();
		if (temp != null) {
			for (int i = 0; i < activeSize; i++) {
				if (temp.equals(activeConnection.get(i))) {
					activeConnection.remove(i);
					freeConncetion.add(temp);
					last++;

					return true;
				}
			}
		}

		System.out.println("Connection not found");

		return false;
	}
	
	public int getFreeConnectionCount() {
		return last+1;
	}
}
