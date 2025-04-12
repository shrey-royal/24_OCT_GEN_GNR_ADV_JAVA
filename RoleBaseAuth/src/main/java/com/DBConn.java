package com;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static final String URL = "jdbc:postgresql://localhost:5432/octgen";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "user";
	private static final String DRIVER = "org.postgresql.Driver";
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException, IOException {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("PostgreSQL JDBC Driver not found.", e);
		}
		return connection;
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(DBConn.getConnection());
//		} catch (SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
