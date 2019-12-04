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

<!-- Only 'if' part is present in jstl -->
<!-- To get this 'if' block executed please pass name parameter to current page url -->
<!-- Example: http://localhost:8080/JSTL_Decision_making/JSTLDemo.jsp?name=harshad -->
<c:if test="${param.name == 'harshad'}">
	Hello Harshad.
</c:if>
Hello User
</body>
</html>