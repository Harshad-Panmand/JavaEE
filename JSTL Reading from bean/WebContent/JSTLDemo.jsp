<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>

<jsp:useBean id="userDetails" class="com.harshad.beans.UserDetails" scope="page"></jsp:useBean>

<!-- Calling getter api using beans  -->
First Name : ${userDetails.getFirstName()}</br>

<!-- Accessing private variables using bean -->
Last Name : ${userDetails.lastName}</br>

<!-- Printing variable using out. NOTE: out tag is optional -->
First Name : <c:out value="${userDetails.getFirstName()}"></c:out>

</body>
</html>