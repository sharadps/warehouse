<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Order MOdel Data</h2>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Order Mode</th>
			<th>Order Code</th>
			<th>Order Method</th>
			<th>Order Accept</th>
			<th>Description</th>
			<th>OPeration</th>
			<th colspan="2">Operation</th>
		</tr>
		<c:forEach items="${list}" var="om">
			<tr>
				<td><c:out value="${om.id}"></c:out></td>
				<td><c:out value="${om.model}"></c:out></td>
				<td><c:out value="${om.code}"></c:out></td>
				<td><c:out value="${om.method}"></c:out></td>
				<td><c:out value="${om.acceptt}"></c:out></td>
				<td><c:out value="${om.dsc}"></c:out></td>
				<td><a href="delete?id=${om.id}">Delete</a></td>
				<td><a href="edit?id=${om.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>${message}</center>
</body>
</html>