package advanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Cookie ck[] = req.getCookies();
		
		if(ck != null) {
			out.println("<h2 style='color: cadetblue;'>" + ck[0].getName() + ": " + ck[0].getValue() + "</h2>");
			out.println("<h2 style='color: cadetblue;'>" + ck[1].getName() + ": " + ck[1].getValue() + "</h2>");
			
			out.println("<a href='cklogout' style='color: coral;'>Logout</a>");
		
		} else {
			out.println("<h2 style='color: coral;'>No cookies Found!</h2>");
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
}
