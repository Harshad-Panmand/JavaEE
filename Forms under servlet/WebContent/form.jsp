<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form demo</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Controller" method="post">
		Full Name:<input type="text" name="name"><br />
		Gender:<br />
		<input type="radio" name="gender" value="Male">Male<br />
		<input type="radio" name="gender" value="Female">Female<br />

		Known Languages:<br /> 
		<input type="checkbox" name="language" value="English">English<br /> 
		<input type="checkbox" name="language" value="Hindi">Hindi<br /> 
		<input type="checkbox" name="language" value="Marathi">Marathi<br />

		Country:<select name="country">
			<option value="India">India</option>
			<option value="China">China</option>
			<option value="Nepal">Nepal</option>
			<option value="Bhutan">Bhutan</option>
			<option value="Srilanka">Srilanka</option>
		</select>
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>