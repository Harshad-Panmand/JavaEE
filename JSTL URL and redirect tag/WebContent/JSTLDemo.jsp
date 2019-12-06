<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>

<c:url value="/AnotherPage.jsp"/>

<a href="<c:url value="/AnotherPage.jsp"/>">Another Page</a>

<c:redirect url="/AnotherPage.jsp"></c:redirect>

</body>
</html>