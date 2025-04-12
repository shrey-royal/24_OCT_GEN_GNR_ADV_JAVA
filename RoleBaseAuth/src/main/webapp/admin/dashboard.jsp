<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession session = request.getSession(false);
    String role = (String) session.getAttribute("role");
    if (!"ADMIN".equals(role)) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<h1>Welcome Admin</h1>
<a href="../logout">Logout</a>
	
</body>
</html>