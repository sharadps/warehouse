<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment Type</title>
</head>
<body>
	<div>
		<h2>Shipment Type</h2>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Shipment Type</th>
			<th>Shipment Code</th>
			<th>Enable Shipment</th>
			<th>Shipment Grade</th>
			<th>Description</th>
			<th colspan="2">Operation</th>
		</tr>
		<c:forEach items="${list}" var="stype">
			<tr>
				<td><c:out value="${stype.id}"></c:out></td>
				<td><c:out value="${stype.stmode}"></c:out></td>
				<td><c:out value="${stype.code}"></c:out></td>
				<td><c:out value="${stype.enabled}"></c:out></td>
				<td><c:out value="${stype.grade}"></c:out></td>
				<td><c:out value="${stype.dsc}"></c:out></td>
				<td><a href="delete?id=${stype.id}">Delete</a></td>
				<td><a href="edit?id=${stype.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>${message}</center>

</body>
</html>