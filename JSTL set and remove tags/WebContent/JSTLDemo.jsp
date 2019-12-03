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

<c:set var="name" value="Harshad"></c:set>
1 :
<c:out value="name"></c:out></br>
2 :
<c:out value="${name}"></c:out></br>
3 :
${name}</br>
4 :
<c:remove var="name"/></br>
${name}

</body>
</html>