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

<c:forEach var="i" begin="0" end="10">
${i}
</c:forEach>
</br>
--------------------------------
</br>
<%-- step attribute is stepping value of for loop --%>
<c:forEach var="i" begin="0" end="32" step="3">
${i}
</c:forEach>
</br>
--------------------------------
</br>
<%
	String[] players = new String[3];
	players[0] = "Sehwag";
	players[1] = "Rohit";
	players[2] = "Pujara";
%>

<c:forEach items="<%=players%>" var="playerName">
${playerName}</br>
</c:forEach>
</br>
--------------------------------
</br>
<c:forTokens items="www.google.com" delims="." var="temp">
${temp}</br>
</c:forTokens>

</body>
</html>