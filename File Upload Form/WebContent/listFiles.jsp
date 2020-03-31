<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.hibernate.entity.Files" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing Images</title>
</head>
<body>


<h1>Listing Images</h1>
<table border="1">
<tr>
<th>Preview</th>
<th>Available Information</th>
<th>Update Information</th>
<th>Available Action</th>
<%
	List<Files> files = (List<Files>)request.getAttribute("files");
	String path = (String) request.getAttribute("path");
	int fileId = 0;

	String updateForm =	"";

	for (Files file : files) {

		out.print("<tr><td><img src=" + "'" + path + file.getFileName() + "'" + "height='200'" + ">" + "</td>");

		fileId =file.getId();

		out.print("<td><ul>" +
		"<li>File ID:" + fileId + "</li>" +
		"<li>File Name:" + file.getFileName() + "</li>" +
		"<li>File Label:" + file.getCaption() + "</li>" +
		"<li>File Caption:" + file.getLabel() + "</li>" +
		"</ul></td>" +
		"<td>"+
		"<form action='FilesHandler' method='post'>"+
		"Label: <input type='text' name='label'/> <br/><br/>"+
		"Caption: <input type='text' name='caption'/> <br/><br/>"+
		"<input type='hidden' name='fileId' value='"+fileId+"'>"+
		"<input type='hidden' name='action' value='updateInformation'>"+
		"<input type='submit' name='Update'>"+
		"</form>"+
		"</td>");

		out.print("<td>" +
				"<ul><li>" +
				"<a href='" + request.getContextPath() + "/FilesHandler?action=viewImage&fileId=" + fileId + "'>View</a>" +
				"</li></ul>");

		out.print("<ul><li>" +
				"<a href='" + request.getContextPath() + "/FilesHandler?action=deleteImage&fileId=" + fileId + "'" +
				"onclick=\"if(!confirm('Are you sure to delete this file?')) return false\">Delete</a>" +
				"</li></ul>" +
				"</td>" +
				"</tr>");
	}
%>


</table>
</body>
</html>