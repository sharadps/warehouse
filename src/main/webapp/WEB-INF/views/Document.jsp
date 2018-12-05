<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document</title>
<style type="text/css">
.effects {
	border: 1px solid black;
	width: 600px;
	margin: auto;
}

h2 {
	text-align: center;
}

.tab {
	margin: auto;
}
</style>
</head>
<body>
	<h2>Welcome to Document Page</h2>
	<form action="upload" method="post" enctype="multipart/form-data"
		class="effects">
		<pre>
			File :	<input type="file" name="file" /><br />
			<input type="submit" value="Upload">
		</pre>
	</form>
	<br /> ${message}
	<br />

	<table border="1" cellpadding="4" cellspacing="3" class="tab">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Link</th>
		</tr>
		<c:forEach items="${docs}" var="doc">
			<tr>
				<td><c:out value="${doc[0]}"></c:out></td>
				<td><c:out value="${doc[1]}"></c:out></td>
				<td><a href="dow?id=${doc[0]}">Download</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
<center>${message}</center>
</html>