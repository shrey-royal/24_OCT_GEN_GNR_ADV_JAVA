<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition</title>
</head>
<body>
	<% int n1 = Integer.parseInt(request.getParameter("n1")); %>
	<% int n2 = Integer.parseInt(request.getParameter("n2")); %>
	
	Addition = <%= n1 + n2 %>
	<br>
	Division = <%= n1 / n2 %>
</body>
</html>