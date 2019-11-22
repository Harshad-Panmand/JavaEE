<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Session Property</title>
</head>
<body>

<jsp:useBean id="userDetails" class="com.harshad.beans.UserDetails" scope="session"></jsp:useBean>

<jsp:setProperty property="firstName" name="userDetails" value="John"/>
<jsp:setProperty property="lastName" name="userDetails" value="Doe"/>

Values have been set using 'session' scope

</body>
</html>