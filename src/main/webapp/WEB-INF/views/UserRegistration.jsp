<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form:form action="insert" method="POST" modelAttribute="user">
	 Name :	<form:input path="userName" />
	
	Email	:	<form:input path="userEmail" />
	
	Password	:	<form:password path="userPassword" />
	
	Rolls	: <form:checkbox path="rolls" value="Admin" /> Admin
			<form:checkbox path="rolls" value="Employee" /> Employee
			
			<input type="submit" value="Register">

	</form:form>

	${message}

</body>
</html>