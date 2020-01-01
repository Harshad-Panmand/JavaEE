<%@ include file="/include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.db.entity.Actor" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<Strong>List Actors</Strong>
			</hr>
			<table border="1">
				<thead>
					<th>User ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Last Update</th>
				</thead>
				<%
					List<Actor> listActors = (List) request.getAttribute("listActors");
					for (int i = 0; i < listActors.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listActors.get(i).getActor_id() + "</td>");
						out.print("<td>" + listActors.get(i).getFirst_name() + "</td>");
						out.print("<td>" + listActors.get(i).getLast_name() + "</td>");
						out.print("<td>" + listActors.get(i).getLast_update() + "</td>");
						out.print("</tr>");
					}
				%>

			</table>
		</div>
	</div>
</div>

<%@ include file="/include/footer.jsp" %>