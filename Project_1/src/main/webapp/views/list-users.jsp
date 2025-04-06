<%@page import="com.usercrud.dao.UserDao"%>
<%@page import="com.usercrud.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    
    <!-- Materialize CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">

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
        .search-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        .search-container .input-field {
            width: 60%;
        }
        #searchInput,
        #userTable_info {
        	color:white;
        }
        .search-container .select-wrapper {
            width: 30%;
        }
        
        #userTable_filter,
		#userTable_length {
		    display: none;
		}
    </style>

    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
    
    <!-- DataTables JS -->
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

    <!-- Materialize JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>User List</h2>
        
        <div class="search-container">
            <div class="input-field">
                <input id="searchInput" type="text">
                <label for="searchInput">Search</label>
            </div>
            
            <div class="select-wrapper">
                <select id="entriesPerPage" class="browser-default">
                    <option value="10" selected>10 entries</option>
                    <option value="25">25 entries</option>
                    <option value="50">50 entries</option>
                </select>
            </div>
        </div>
        
        <!-- User Table -->
        <table id="userTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>
    </div>

    <script>
        $(document).ready(function() {
            var table = $('#userTable').DataTable({
                "paging": true,
                "searching": true,
                "ordering": true,
                "order": [[0, 'asc']],
                "pageLength": 10
            });

            $('#searchInput').on('keyup', function() {
                table.search(this.value).draw();
            });

            $('#entriesPerPage').on('change', function() {
                var pageLength = parseInt(this.value);
                table.page.len(pageLength).draw();
            });
        });

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
