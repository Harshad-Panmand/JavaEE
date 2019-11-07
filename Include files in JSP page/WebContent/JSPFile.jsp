<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP File</title>
</head>
<body>

<%-- Use below tag for including static content file --%>
<%@ include file = "file1.txt" %>
<br/>

<%-- Use below tag for including dynamic content file --%>
<jsp:include page="file2.txt"></jsp:include>

</body>
</html>