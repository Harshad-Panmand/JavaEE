<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello JSP Expressions</title>
</head>
<body>
	<%!public int x = 3;%>
	<%=x%>
	<br />
	<%=new Integer(22)%>
	<br />
	<%=new Date()%>
	<br />
	<%=2 > 5%>
</body>
</html>