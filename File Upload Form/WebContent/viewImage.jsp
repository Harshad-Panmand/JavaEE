<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.hibernate.entity.Files"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Image</title>
</head>
<body>

<%! Files file; String path; %>
<%
	file = (Files) request.getAttribute("file");
	path = (String) request.getAttribute("path");
%>

File Id: <%= file.getId() %> | File Name: <%= file.getFileName() %>  
<%
	if(file.getLabel() != null)
		out.print("Label: "+file.getLabel());
%>
<%
	if(file.getCaption() != null)
		out.print("Caption: "+file.getCaption());
%>

| <a href="${pageContext.request.contextPath}">Home </a>
| <a href="${pageContext.request.contextPath}/FilesHandler?action=listingImages">List available images</a>

<img src="<%=path + file.getFileName()%>">

</hr>
</body>
</html>