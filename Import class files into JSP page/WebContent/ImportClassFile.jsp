<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Import class file in JSP</title>
</head>
<body>
	<%-- Using 'include' keyword we can only include file --%>
	<%-- Where as using 'import' we can only import 'type' like class --%>
	<%@ page import="java.util.Date"%>
	<%=new Date() %>
	<br>
	<%-- import user defined type i.e. class --%>
	<%@ page import="com.harshad.servlets.DemoClass"%>
	<% out.print(new DemoClass().printDemo()); %>
</body>
</html>
