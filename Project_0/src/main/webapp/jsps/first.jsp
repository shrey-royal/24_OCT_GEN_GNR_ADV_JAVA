<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Page</title>
</head>
<body>
	<h1 style="color: cadetblue;">This is a JSP Page</h1>
	
	<h1>Scripting Elements</h1>
	<p style="color: coral;">
		Scriptlet Tag: 
		<% /* Java source code */ 
			out.println(Calendar.getInstance().getTime().toString());
		%>
	</p>
	<hr>
	
	<p style="color: tomato;">
		Expression Tag: <%= Calendar.getInstance().getTime().toString() %>
	</p>
	<hr>
	
	<%! String punjabi = "Fuddu"; %>
	<p style="color: orangered;">Declaration Tag: <%= punjabi %></p>
	<hr>
	
	<form action="de.jsp">
		Name: <input type="text" name="name" style="color: red;" placeholder="enter your name">
		<br>
		<input type="submit" value="Submit" style="color: red;">
	</form>
	<hr>
</body>
</html>