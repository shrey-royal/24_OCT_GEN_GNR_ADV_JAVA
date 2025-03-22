package advanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the background color from the session (if any)
        HttpSession session = request.getSession();
        String bgColor = (String) session.getAttribute("bgColor");

        // If no color is set, default to a light grey color
        if (bgColor == null) {
            bgColor = "#f0f0f0";  // Default background color
        }

        // Set the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // HTML content with inline JavaScript for clock and color picker
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Minimal Clock with Session</title>");
        out.println("<style>");
        out.println("body { height: 100vh; display: flex; justify-content: center; align-items: center; background-color: " + bgColor + "; }");
        out.println(".clock { font-size: 5rem; font-weight: bold; color: #333; text-align: center; }");
        out.println(".color-picker { position: absolute; top: 20px; right: 20px; padding: 5px; border: none; background-color: transparent; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='clock' id='clock'>00:00:00</div>");
        out.println("<input type='color' id='colorPicker' class='color-picker' value='" + bgColor + "' />");
        out.println("<script>");
        out.println("function updateClock() {");
        out.println("  const clockElement = document.getElementById('clock');");
        out.println("  const now = new Date();");
        out.println("  const hours = now.getHours().toString().padStart(2, '0');");
        out.println("  const minutes = now.getMinutes().toString().padStart(2, '0');");
        out.println("  const seconds = now.getSeconds().toString().padStart(2, '0');");
        out.println("  clockElement.textContent = hours + ':' + minutes + ':' + seconds;");
        out.println("}");
        out.println("setInterval(updateClock, 1000);");
        out.println("updateClock();");

        // JavaScript to handle the color change and send it to the server via POST
        out.println("const colorPicker = document.getElementById('colorPicker');");
        out.println("colorPicker.addEventListener('input', function(e) {");
        out.println("  document.body.style.backgroundColor = e.target.value;");
        out.println("  console.log('color change!');");
        out.println("  fetch('/Project_0/updateBackgroundColor', {");
        out.println("    method: 'POST',");
        out.println("    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },");
        out.println("    body: 'bgColor=' + encodeURIComponent(e.target.value)");
        out.println("  });");
        out.println("});");
        
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handles POST request to update the session with the selected background color
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the background color parameter from the request
        String bgColor = request.getParameter("bgColor");

        // Save the background color in the session
        HttpSession session = request.getSession();
        session.setAttribute("bgColor", bgColor);

        // Respond with a simple OK status (optional)
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
