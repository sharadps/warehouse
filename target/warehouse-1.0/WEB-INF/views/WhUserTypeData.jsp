<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WhUserType Data</title>
</head>
<body>
	<div>
		<h2>WhUserType Data</h2>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>User Type</th>
			<th>User Code</th>
			<th>Users For</th>
			<th>User Email</th>
			<th>User Contact</th>
			<th>User Id Type</th>
			<th>If Other</th>
			<th>Id Number</th>
			<th colspan="2">OPeration</th>
		</tr>
		<c:forEach items="${list}" var="whyt">
			<tr>
				<td><c:out value="${whyt.id}"></c:out></td>
				<td><c:out value="${whyt.whtype}"></c:out></td>
				<td><c:out value="${whyt.code}"></c:out></td>
				<td><c:out value="${whyt.forType}"></c:out></td>
				<td><c:out value="${whyt.email}"></c:out></td>
				<td><c:out value="${whyt.contact}"></c:out></td>
				<td><c:out value="${whyt.idType}"></c:out></td>
				<td><c:out value="${whyt.ifOther}"></c:out></td>
				<td><c:out value="${whyt.idNumber}"></c:out></td>
				<td><a href="edit?id=${whyt.id}">Edit</a></td>
				<td><a href="delete?id=${whyt.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>${message}</center>
</body>
</html>