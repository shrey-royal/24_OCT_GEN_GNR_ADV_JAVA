package rd_auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RD_Auth_Failed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String username = (String) req.getAttribute("uname");
		String usernameError = (String) req.getAttribute("unameError");
		String passwordError = (String) req.getAttribute("passError");
		
		out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("  <title>Login Form</title>");
        out.println("  <style type='text/css'>");
        out.println("    * { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("    body { font-family: 'Arial', sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println("    .login-container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); width: 100%; max-width: 400px; }");
        out.println("    h2 { text-align: center; margin-bottom: 20px; font-size: 24px; color: #333; }");
        out.println("    .input-field { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; font-size: 16px; background-color: #fafafa; }");
        out.println("    .error { color: red; font-size: 12px; }");
        out.println("    .submit-btn { width: 100%; padding: 10px; border: none; background-color: #4CAF50; color: white; font-size: 16px; border-radius: 5px; cursor: pointer; transition: background-color 0.3s; }");
        out.println("    .submit-btn:hover { background-color: #45a049; }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <div class='login-container'>");
        out.println("    <form class='login-form' action='rd-auth' method='POST'>");
        out.println("      <h2>Login</h2>");
        
        // Username field with value set to previously entered username
        out.println("      <input type='text' placeholder='Username' class='input-field' name='username' required value='" + (username != null ? username : "") + "'>");
        // Display username error if it exists
        if (usernameError != null) {
            out.println("      <div class='error'>" + usernameError + "</div>");
        }
        
        // Password field
        out.println("      <input type='password' placeholder='Password' class='input-field' name='password' required>");
        // Display password error if it exists
        if (passwordError != null) {
            out.println("      <div class='error'>" + passwordError + "</div>");
        }
        
        // Submit button
        out.println("      <button type='submit' class='submit-btn'>Login</button>");
        out.println("    </form>");
        out.println("  </div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
	}
}
