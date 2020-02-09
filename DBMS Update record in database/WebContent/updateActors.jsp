<%@ include file="/include/header.jsp" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<form action="${pageContext.request.contextPath}/operation" method="post">
			First Name: <input type="text" name="firstname" value="${param.firstname }" required="required"/><br>
			Last Name : <input type="text" name="lastname" value="${param.lastname}" required="required"/><br>
			<input type="hidden" name="actorId" value="${param.actorId}">
			<input type="hidden" name="form" value="updateactoroperation">
			<input type="submit" value="Update Actor">
		</div>
	</div>
</div>

<%@ include file="/include/footer.jsp" %>