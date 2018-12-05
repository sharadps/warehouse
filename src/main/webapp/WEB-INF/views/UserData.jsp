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

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Rolls</th>
		</tr>
		<c:forEach items="${list}" var="user">
		<tr>
			<td><c:out value="${user.userId}"></c:out></td>
			<td><c:out value="${user.userName}"></c:out></td>
			<td><c:out value="${user.userEmail}"></c:out></td>
			<td><c:out value="${user.userPassword}"></c:out></td>
			<td><c:out value="${user.rolls}"></c:out></td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>