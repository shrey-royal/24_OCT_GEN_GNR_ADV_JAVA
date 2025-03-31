package com.usercrud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usercrud.bean.UserBean;
import com.usercrud.dao.UserDao;

@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	
    	UserBean user = new UserDao().getUserById(id);
    	
    	if (user != null) {
    		req.setAttribute("user", user);
    		req.getRequestDispatcher("views/editUser.jsp").forward(req, res);
    	} else {
    		res.sendError(500, "User is NULL!");
    	}
    }

}
