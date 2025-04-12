<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>Login</title></head>
<body>
    <form action="login" method="post">
        Username: <input name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        <input type="submit" value="Login" />
    </form>
    ${error != null ? error : ""}
</body>
</html>
