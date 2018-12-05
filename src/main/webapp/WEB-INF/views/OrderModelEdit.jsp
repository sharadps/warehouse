<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Method</title>
</head>
<body>
	<div>
		<h2>Order Method</h2>
	</div>
	<form:form action="update" method="POST" modelAttribute="om">
		<pre>
			Id			:	<form:input path="omId" readonly="true"/>
			Order Mode	:	<form:radiobutton path="omModel" value="sale" />Sale
						<form:radiobutton path="omModel" value="purchase" />Purchase <br />
			Order Code	:	<form:input path="omCode" />
			<br />
			Order Method	:	<form:select path="omMethod">
							<form:option value="">-- Select --</form:option>
							<form:option value="fifo"> FIFO</form:option>
							<form:option value="lifo">LIFO</form:option>
							<form:option value="fcfo">FCFO</form:option>
							<form:option value="fefo">FEFO</form:option>
							</form:select>
			<br />
			Order Accept	:	<form:checkbox path="omAcceptt" value="multimodel" />Multi-Model
						<form:checkbox path="omAcceptt" value="acceptreturn" />Accept-Return
							<br />
			Description	:	<form:textarea path="omDsc" />
			<br />
			<input type="submit" value="Update Order Method">
		</pre>
	</form:form>
	<center>${message}</center>
</body>
</html>