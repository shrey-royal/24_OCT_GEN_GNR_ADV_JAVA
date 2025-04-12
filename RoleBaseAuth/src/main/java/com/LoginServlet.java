package com;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT role FROM user0 WHERE username = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String role = rs.getString("role");
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				session.setAttribute("role", role);
				
				if ("ADMIN".equals(role)) {
					res.sendRedirect("admin/dashboard.jsp");
				} else {
					res.sendRedirect("user/home.jsp");
				}
			} else {
				req.setAttribute("error", "Invalid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
