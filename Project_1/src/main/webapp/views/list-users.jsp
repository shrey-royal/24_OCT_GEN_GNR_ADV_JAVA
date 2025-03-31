<%@page import="com.usercrud.dao.UserDao"%>
<%@page import="com.usercrud.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
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
            width: 80%;
            margin: auto;
            background: #111;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #fff;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #222;
        }
        td {
            background: #333;
        }
        .btn {
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .edit-btn {
            background: #4CAF50;
            color: white;
        }
        .delete-btn {
            background: #E53935;
            color: white;
        }
        .btn:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>User List</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            <%
            	UserDao dao = new UserDao();
                ArrayList<UserBean> users = dao.getAllUsers();
                if (users != null) {
                    for (UserBean user : users) {
            %>
                        <tr>
                            <td><%= user.getId() %></td>
                            <td><%= user.getName() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getPassword() %></td>
                            <td>
                                <button class="btn edit-btn" onclick="editUser(<%= user.getId() %>)">Edit</button>
                                <button class="btn delete-btn" onclick="deleteUser(<%= user.getId() %>)">Delete</button>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr><td colspan="5">No users found.</td></tr>
            <%
                }
            %>
        </table>
    </div>

    <script>
        function editUser(userId) {
            window.location.href = '/Project_1/editUser?id=' + userId;
        }
        function deleteUser(userId) {
            if (confirm('Are you sure you want to delete this user?')) {
                window.location.href = '/Project_1/deleteUser?id=' + userId;
            }
        }
    </script>
</body>
</html>
