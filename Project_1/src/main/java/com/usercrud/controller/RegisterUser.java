package com.usercrud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usercrud.bean.UserBean;
import com.usercrud.dao.UserDao;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserBean user = new UserBean(name, email, password);
		UserDao dao = new UserDao();
		
		if (dao.saveUser(user)) {
			res.sendRedirect("/Project_1/views/list-users.jsp");
		} else {
			res.sendError(500, "Error saving the user");
		}
	}
	
}
