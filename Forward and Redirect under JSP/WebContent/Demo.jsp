<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
	It's from original page

	
	<!-- Forwarding request using jsp tags -->
	<%-- <jsp:forward page="Forward.jsp"></jsp:forward> --%>

	<%-- Forwarding request using scriptlet tags --%>
	<%-- <%
		request.getRequestDispatcher("Forward.jsp").forward(request, response);
	%> --%>
	
	<%-- Redirecting request using scriptlet tags --%>
	<%
		response.sendRedirect("Redirect.jsp");
	%>
	
</body>
</html>