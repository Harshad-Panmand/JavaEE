<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>After Login page</title>
</head>
<body>

<%
	String userName = null, sessionID = null;
	Object sessionAttributeUserNameObj = request.getSession().getAttribute("userName");
	if(sessionAttributeUserNameObj == null){
		response.sendRedirect("Login.jsp");
	} else {
		userName = sessionAttributeUserNameObj.toString();
		sessionID = request.getSession().getId();
	}
%>
User Name Cookie:<%=userName %>
</br>
SessionID cookie:<%=sessionID %>
</br>

<form action="<%=request.getContextPath()%>/AfterLoginController" method="get">
<input type="hidden" name="action" value="destroy">
<input type="submit" value="logout">
</form>

</body>
</html>