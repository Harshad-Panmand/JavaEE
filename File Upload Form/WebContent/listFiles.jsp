<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.hibernate.entity.Files" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing Images</title>
</head>
<body>
<h1>Listing Images</h1>
<table border="1">
<tr>
<th>Preview</th>
<th>Available Information</th>
<th>Update Information</th>
<th>Action</th>
<%
	List<Files> files = (List<Files>)request.getAttribute("files");
	String path = (String) request.getAttribute("path");

	for (Files file : files) {
		out.print("<tr><td><img src=" + "'" + path + file.getFileName() + "'" + "height='200'" + ">"
				+ "</td></tr>");
	}
%>
</table>
</body>
</html>