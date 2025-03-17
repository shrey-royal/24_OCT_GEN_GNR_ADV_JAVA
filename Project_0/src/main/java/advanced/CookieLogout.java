package advanced;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie ck[] = req.getCookies();
		
		for (Cookie cookie : ck) {
			cookie.setMaxAge(0);	// to delete the cookies
//			cookie.setValue("");	// to clear the cookie values
			res.addCookie(cookie);
		}
		
		res.sendRedirect("http://localhost:9090/Project_0/ckhome");

	}
	
}
