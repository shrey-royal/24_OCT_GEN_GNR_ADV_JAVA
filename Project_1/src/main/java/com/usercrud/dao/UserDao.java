package com.usercrud.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.usercrud.bean.UserBean;
import com.usercrud.util.DBConnection;

public class UserDao {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String query;
	boolean status;
	
	public boolean saveUser(UserBean user) {
		status = false;
		try {
			conn = DBConnection.getConnection();
			query = "INSERT INTO users(name, email, password) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			if (pstmt.executeUpdate() > 0) {
				status = true;
				System.out.println("new user saved");
			} else {
				System.out.println("failed to save new user");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> userList = null;
		try {
			conn = DBConnection.getConnection();
			query = "SELECT * FROM users";
			rs = conn.createStatement().executeQuery(query);
			userList = new ArrayList<UserBean>();
			while (rs.next()) {
				userList.add(
						new UserBean(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getString("email"),
								rs.getString("password")
								)
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			try {
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}

	public UserBean getUserById(int id) {
		UserBean user = null;
		try {
			conn = DBConnection.getConnection();
			query = "SELECT * FROM users WHERE id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getString("password")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			try {
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public boolean updateUser(UserBean user) {
		status = false;
		try {
			conn = DBConnection.getConnection();
			query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getId());
			
			if (pstmt.executeUpdate() > 0) {
				status = true;
				System.out.println("user updated");
			} else {
				System.out.println("failed to update user");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public boolean deleteUser(int id) {
		status = false;
		try {
			conn = DBConnection.getConnection();
			query = "DELETE FROM users WHERE id = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			if (pstmt.executeUpdate() > 0) {
				status = true;
				System.out.printf("user with id(%d) deleted", id);
			} else {
				System.out.printf("failed to delete user with id(%d)", id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query = null;
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
}
