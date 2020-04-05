<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.Oauth.model.UserInfo" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>
<body>

<% UserInfo userInfo = (UserInfo)request.getAttribute("userInfo"); %>

<img alt="User Image" src="<%=userInfo.getPicture()%>">
Email: <%=userInfo.getEmail()%>
</body>
</html>