<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<form action="signupservlet" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="first_name" required></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="last_name" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
<a href="signin.jsp">Already have an account? Sign In</a>
</body>
</html>
