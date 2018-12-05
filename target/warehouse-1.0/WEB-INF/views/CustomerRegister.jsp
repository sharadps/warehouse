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
	<div>
		<h2>Customer Registration</h2>
	</div>
	<form:form action="insert" method="POST" modelAttribute="cust">
		<pre>
			Customer Code	:	<form:input path="custCode" />
			<br />
			 Address	:	<form:textarea path="custAddress" />
			<br />
			Location	:	<form:select path="custLocs" multiple="true">
						 	<%--  <form:options items="${locs}" />  --%>
							<form:options items="${Hyberabad,Bangalor}" />
							</form:select>
			<br />
			Enabled		:	 <form:radiobutton path="custEnabled" value="yes" />YES
							<form:radiobutton path="custEnabled" value="no" /> NO <br />
			Email	:	<form:input path="custEmail" />
			<br />
			Contact	:	<form:input path="custContact" />
			<br />
			
			<input type="submit" value="Customer Register">
		</pre>
	</form:form>
</body>
</html>