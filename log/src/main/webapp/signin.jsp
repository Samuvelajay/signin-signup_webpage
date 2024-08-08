<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
<h1>Sign In</h1>
<form action="signinservlet" method="post">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
    </table>
    <input type="submit" value="Sign In">
</form>
<a href="signUp.jsp">Don't have an account? Sign Up</a>
</body>
</html>
