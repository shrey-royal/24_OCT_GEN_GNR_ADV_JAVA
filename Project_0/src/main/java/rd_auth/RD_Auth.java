package rd_auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RD_Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String unameError = null;
		String passError = null;
		
		if (uname == null || uname.isEmpty() || !uname.equals("admin")) {
			unameError = "Username is wrong!";
		}
		
		if (pass == null || pass.isEmpty() || !pass.equals("admin")) {
			passError = "Password is wrong!";
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = null;
		
		if (uname.equals("admin") && pass.equals("admin")) {
			rd = req.getRequestDispatcher("/html/rd_homepage.html");
			rd.forward(req, res);
		} else {
			req.setAttribute("uname", uname);
			req.setAttribute("unameError", unameError);
			req.setAttribute("passError", passError);
			rd = req.getRequestDispatcher("/rd-auth-failed");
			rd.forward(req, res);
		}
		
		out.close();
	}
}
