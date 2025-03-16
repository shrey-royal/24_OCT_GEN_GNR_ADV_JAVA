package basics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RD_Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url_value = req.getParameter("url");
		
		if (url_value != "") {
			res.sendRedirect(url_value);
		} else {
			res.sendError(404, "No URL found!");
		}
	}
}
