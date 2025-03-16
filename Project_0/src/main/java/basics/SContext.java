package basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head><title>YOLO</title>");
		out.println("<style>");
		out.println("table { border: 1px solid black; border-collapse: collapse; width: fit-content; }");
		out.println("th, td { border: 1px solid black; padding: 8px; text-align: center; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr><th>Param Name</th><th>Param Value</th></tr>");
		out.println("</thead><tbody>");
		
		ServletContext context = getServletContext();
		Enumeration<String> names = context.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			out.println("<tr><td>"+name+"</td><td>"+context.getInitParameter(name)+"</td></tr>");
		}
		out.println("</tbody>");
		out.println("</table></body></html>");
		
		out.close();
	}
}
