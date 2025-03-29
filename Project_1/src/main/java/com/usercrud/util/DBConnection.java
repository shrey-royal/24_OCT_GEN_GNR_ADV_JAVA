package com.usercrud.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException, IOException {
		if (connection == null) {
			synchronized (DBConnection.class) {
				if (connection == null) {
					Properties properties = new Properties();
					FileInputStream inputStream = new FileInputStream("src/main/webapp/WEB-INF/application.properties");
					properties.load(inputStream);
					
					String url = properties.getProperty("db.url");
					String username = properties.getProperty("db.username");
					String password = properties.getProperty("db.password");
					String driver = properties.getProperty("db.driver");
					
					try {
						Class.forName(driver);
						connection = DriverManager.getConnection(url, username, password);
					} catch (ClassNotFoundException e) {
						throw new SQLException("PostgreSQL JDBC Driver not found.", e);
					}
				}
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = getConnection();
			if (conn != null) {
				System.out.println("Connection to the database was successful!");
			} else {
				System.out.println("Failed to make a connection.");
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
