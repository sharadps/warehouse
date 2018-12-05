<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Register</title>
</head>
<body>
	<div class="">
		<h2>Customer Registration</h2>
	</div>
	<form:form action="update" method="POST" modelAttribute="cust"
		class="effects">
		<pre>
			Id		:	<form:input path="custId" readonly="true" />
			<br />
			Customer Code	:	<form:input path="custCode" />
			<br />
			 Address	:	
			 			<form:textarea path="custAddress" />
			<br />
			Location	:
						<form:select path="custLocs" multiple="true">
						 	<form:option value="Pune">Pune</form:option>
						 	<form:option value="Hyderabad">Hyderabad</form:option>
						 	<form:option value="Bangalor">Bangalor</form:option>
						 	<form:option value="Mumbai">Mumbai</form:option>
							
							</form:select>
			<br />
			Enabled		:	 <form:radiobutton path="custEnabled" value="yes" />YES <form:radiobutton
				path="custEnabled" value="no" />NO <br />
						 
			Email		:	<form:input path="custEmail" />
			<br />
			Contact		:	<form:input path="custContact" />
			<br />
			
			<input type="submit" value="Customer Update">
		</pre>
	</form:form>
	<center>${message}</center>
</body>
</html>