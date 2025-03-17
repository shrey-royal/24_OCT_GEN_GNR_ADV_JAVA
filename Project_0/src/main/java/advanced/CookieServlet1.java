package advanced;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean rememberMe = req.getParameter("rememberMe") == null ? false : true;
		
		if (rememberMe) {
			res.addCookie(new Cookie("uname", req.getParameter("username")));
			res.addCookie(new Cookie("pass", req.getParameter("password")));
		}
		req.getRequestDispatcher("ckhome").forward(req, res);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
