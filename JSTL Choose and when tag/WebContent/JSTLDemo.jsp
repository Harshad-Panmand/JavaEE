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

<c:choose>
	<c:when test="${param.lang == 'java'}">
		Learning Java
	</c:when>
	<%-- this is not working, need to look in to it --%>
	<c:when test="${param.lang == 'c++'}">
		Learning C++
	</c:when>
	<c:when test="${param.lang == 'php'}">
		Learning PHP
	</c:when>
	<%-- Default condition --%>
	<c:otherwise>
		Learning something is good.
	</c:otherwise>
</c:choose>

</body>
</html>