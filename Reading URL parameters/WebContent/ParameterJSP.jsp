<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP parameters</title>
</head>
<body>
<%
out.print("Harshad");
out.print("Value 1:" +request.getParameter("value1"));
%>
<br/>
<%
out.print("Value 2:" +request.getParameter("value2"));
%>
</body>
</html>