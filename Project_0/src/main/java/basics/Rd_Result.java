package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rd_Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String naam = (String) req.getAttribute("naam");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; color: #333; margin: 0; padding: 0; }");
        out.println("header { background-color: #4CAF50; color: white; padding: 20px; text-align: center; }");
        out.println("h1 { font-size: 28px; margin: 0; }");
        out.println("p { font-size: 20px; color: #555; text-align: center; margin-top: 20px; }");
        out.println("footer { text-align: center; padding: 20px; background-color: #333; color: white; margin-top: 40px; }");
        out.println("</style>");
        out.println("</head><body>");
        
        out.println("<header><h1>Hello, " + naam + "!</h1></header>");
        
        out.println("<p>Welcome to the Result Servlet!</p>");
        
        req.getRequestDispatcher("/html/rd_footer.html").include(req, res);
        
        out.println("</body></html>");
        
        out.close();
	}

}
