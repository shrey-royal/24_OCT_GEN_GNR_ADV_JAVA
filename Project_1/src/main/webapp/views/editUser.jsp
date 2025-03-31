<%@page import="com.usercrud.dao.UserDao"%>
<%@page import="com.usercrud.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #000;
            color: #fff;
            text-align: center;
        }
        .container {
            width: 50%;
            margin: auto;
            background: #111;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
        }
        h2 {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            background: #333;
            border: 1px solid #fff;
            color: white;
            border-radius: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            background: #4CAF50;
            color: white;
            border-radius: 5px;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background: #45a049;
        }
        .btn-back {
            padding: 5px 10px;
            background: #ff9800;
            color: white;
            border: none;
            border-radius: 5px;
            margin-top: 10px;
            cursor: pointer;
        }
        .btn-back:hover {
            background: #fb8c00;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit User</h2>
        <%
            UserBean user = (UserBean) request.getAttribute("user");
            if (user != null) {
        %>
            <form action="updateUser" method="post">
                <input type="hidden" name="id" value="<%= user.getId() %>" />
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<%= user.getName() %>" required />
                
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" value="<%= user.getEmail() %>" required />
                
                <label for="password">Password:</label>
                <input type="text" id="password" name="password" value="<%= user.getPassword() %>" required />
                
                <input type="submit" value="Update User" />
            </form>
            <button class="btn-back" onclick="window.location.href='views/list-users.jsp'">Back to User List</button>
        <%
            } else {
        %>
            <p>User not found!</p>
        <%
            }
        %>
    </div>
</body>
</html>
