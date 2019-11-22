<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Application Property</title>
</head>
<body>

<jsp:useBean id="userDetails" class="com.harshad.beans.UserDetails" scope="application"></jsp:useBean>

<jsp:setProperty property="firstName" name="userDetails" value="Harshad"/>
<jsp:setProperty property="lastName" name="userDetails" value="Panmand"/>

Application properties have been reset to default value.

</body>
</html>