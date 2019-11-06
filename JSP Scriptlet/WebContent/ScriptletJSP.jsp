<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Scriptlet</title>
</head>
<body>
<h1><%
int a = 11;
for(;a > 0 ; a--){
	out.print("<br/>");
	out.print(a);
}

%></h1>

<br/>
<%-- we can use 'a' element here also--%>
<%
out.println(a);
%>
</body>
</html>