<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/SiteController" method="post">
User Name: <input type="Text" name="userName">
</br>
Password : <input type="password" name="userPassword">
<input type="hidden" name="action" value="loginSubmit">
<input type="submit" value="Submit">
</form>
</body>
</html>