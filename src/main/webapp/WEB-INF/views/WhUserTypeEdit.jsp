<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>WhUserType Registration</h2>
	</div>
	<form:form action="update" method="POST" modelAttribute="whty">
		<pre>
			Id			:	<form:input path="id" readonly="true" />
			User Type	:	<form:radiobutton path="whtype" value="vendor" />Vendor
							<form:radiobutton path="whtype" value="customer" />Customer<br />
			User Code	:	<form:input path="code" />
			<br />
			Users For	:	<form:input path="forType" />
			<br />
			User Email	:	<form:input path="email" />
			<br />
			User Contact	:	<form:input path="contact" />
			<br />
			User Id Type:	<form:select path="idType">
							<form:option value="">--Select--</form:option>
							<form:option value="pan">PAN CARD</form:option>
							<form:option value="adhar">ADHAR CARD</form:option>
							<form:option value="voter">VOTER ID</form:option>
							<form:option value="other">OTHER</form:option>
							</form:select>
			<br />
			*If Other	:	<form:input path="ifOther" />
			<br />
			Id Number	:	<form:input path="idNumber" />
			<br />
			<input type="submit" value="Update User">
		</pre>
	</form:form>
	<center>${message}</center>
</body>
</html>