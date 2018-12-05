<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Register</title>
</head>
<body>
	<div>
		<h2>Vendor Register</h2>
	</div>
	<form:form action="update" method="POST" modelAttribute="vendor">
		<pre>
			Id		:	<form:input path="venId" readonly="true" />
			<br />
			Name	:	<form:input path="venName" />
			<br />
			Code	:	<form:select path="venCode">
						<form:option value="">--Select--</form:option>
						<form:option value="CAT">CAT</form:option>
						<form:option value="RES">RES</form:option>
						</form:select>
			<br />
			Designation:	<form:radiobutton path="venDesg" value="sales" />Sales
						<form:radiobutton path="venDesg" value="service" />Service
						<form:radiobutton path="venDesg" value="both" />Both
						<br />
			Preserve	:	<form:checkbox path="venPreserve" value="A" />A
							<form:checkbox path="venPreserve" value="B" />B
							<form:checkbox path="venPreserve" value="C" />C
							<br />
							<input type="submit" value="Vendor Update">			
		</pre>
	</form:form>
	<center>${message}</center>
</body>
</html>