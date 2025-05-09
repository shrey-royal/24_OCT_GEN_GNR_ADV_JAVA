package com;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false);
		String role = session != null ? (String) session.getAttribute("role") : null;
		
		boolean isAdminURL = uri.contains("/admin");
		boolean isLoggedIn = role != null;
		
		if (isAdminURL && (!isLoggedIn || !"ADMIN".equals(role))) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(req, res);
		}
	}
}
