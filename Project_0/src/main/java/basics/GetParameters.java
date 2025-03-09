package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
		PrintWriter out = res.getWriter();
		
		out.println("<h2 style=\"color: dodgerblue;\">Email: " + email + "</h2>");
		out.println("<h2 style=\"color: cadetblue;\">Password: " + password + "</h2>");
		
		out.println("<table border='1'>");
		out.println("<thead><tr><td>Email</td><td>Password</td></tr></thead>");
		out.println("<tbody><tr><td>" + email + "</td><td>" + password + "</td></tr></tbody>");
		out.println("</table>");
		
		out.close();
	}
}
