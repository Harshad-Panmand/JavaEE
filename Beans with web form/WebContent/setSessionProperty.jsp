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

<form action="getSessionProperty.jsp">
<!-- Value of 'name' attribute should be exactly same as provided in class -->

First Name: <input type="text" name="firstName" value='<jsp:getProperty property="firstName" name="userDetails"/>'>
</br> 
Last Name: <input type="text" name="lastName" value='<jsp:getProperty property="lastName" name="userDetails"/>'>
</br>
<input type="submit" value="Submit">
</form>
</body>
</html>