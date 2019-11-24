<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Page Property</title>
</head>
<body>

Note: 	page scope is available for currently opened page only.</br>
		for every single page jsp creates new bean</br>

<jsp:useBean id="userDetails" class="com.harshad.beans.UserDetails" scope="page"></jsp:useBean>
</br>
Values before setting the property:</br>
First Name: <jsp:getProperty property="firstName" name="userDetails"/> <br/>
Last Name: <jsp:getProperty property="lastName" name="userDetails"/> <br/>

</br>
Values after setting the property:</br>
<jsp:setProperty property="firstName" name="userDetails" value="John"/>
<jsp:setProperty property="lastName" name="userDetails" value="Doe"/>
First Name: <jsp:getProperty property="firstName" name="userDetails"/> <br/>
Last Name: <jsp:getProperty property="lastName" name="userDetails"/> <br/>

</body>
</html>