<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Session Property</title>
</head>
<body>

<jsp:useBean id="userDetails" class="com.harshad.beans.UserDetails" scope="session"></jsp:useBean>

First Name: <jsp:getProperty property="firstName" name="userDetails"/> <br/>
Last Name: <jsp:getProperty property="lastName" name="userDetails"/> <br/>

</body>
</html>