<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unit Of Measurement</title>
<style type="text/css">
.anch {
	background-color: magneta;
	width: 700px;
	position: relative;
	margin: auto;
}

.tab {
	position: relative;
	margin: auto;
	background-color: #7ABA7A;
	/* border: 1px solid; */
	width: 700px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
}

.effects {
	background-color: #660033;
	border: 1px solid black;
	width: 800px;
	margin: auto;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
	color: white
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="effects">
		<h2>Unit Of Measurement Data</h2>
	</div>
	<table border="1" class="tab" cellpadding="2" cellspacing="2">
		<tr>
			<th>ID</th>
			<th>Uom Type</th>
			<th>Uom Model</th>
			<th>Description</th>
			<th colspan="2">Operation</th>
		</tr>
		<c:forEach items="${list}" var="uom">
			<tr>
				<td><c:out value="${uom.uomId}"></c:out></td>
				<td><c:out value="${uom.uomType}"></c:out></td>
				<td><c:out value="${uom.uomModel}"></c:out></td>
				<td><c:out value="${uom.uomDsc}"></c:out></td>
				<td><a href="delete?id=${uom.uomId}">Delete</a></td>
				<td><a href="edit?id=${uom.uomId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<div class="anch">
		<center>

			<a href="excel" >Generate Excel</a>
		</center>
	</div>

	<center>${message}</center>

</body>
</html>