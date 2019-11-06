<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Declaration JSP</title>
</head>
<body>
	<%-- We can use access specifier jsp declaration, but in here in scriptlet we don't use access specifier --%>
	<h1>Hello declaration JSP</h1>
	<%-- below code is jsp declaration --%>
	<%!String message() {
		return "I love my country";
	}%>

	<%-- below code is jsp expression --%>
	<%=message()%>

	<%-- simply redirect our page to google.com
	this will execute above code and immediately it calls google.comd
	--%>
	<%-- <% response.sendRedirect("http://google.com"); %> --%>


</body>
</html>