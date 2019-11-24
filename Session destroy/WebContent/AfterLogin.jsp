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
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("userName")){
				userName = cookie.getValue();
			}
			if(cookie.getName().equals("JSESSIONID")){
				sessionID = cookie.getValue();
			}
		}
	}
	if(userName == null || sessionID == null){
		response.sendRedirect("Login.jsp");
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