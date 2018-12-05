<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
	<div>
		<h2>ShipmentType</h2>
	</div>
	<form:form action="update" method="POST" modelAttribute="stype">
		<pre>
			Id				:<form:input path="id" readonly="true"/>
			Shipment Type	:	<form:select path="stmode">
								<form:option value="">-- Select --</form:option>
								<form:option value="air">Air</form:option>
								<form:option value="truck">Truck</form:option>
								<form:option value="ship">Ship</form:option>
								<form:option value="train">Train</form:option>
								</form:select>		<br />
			Shipment Code	:	<form:input path="code" />
			<br />
			
			Enable Shipment	:	<form:checkbox path="enabled"  value="yes"/>Yes
			<br />
			Shipment Grade	:	<form:radiobutton path="grade" value="a" />A
								<form:radiobutton path="grade" value="b" />B
								<form:radiobutton path="grade" value="c" />C<br />
			Description		:	<form:textarea path="dsc"/><br />
			
			<input type="submit" value="Update Shipment">
		
		</pre>
	</form:form>
	<center>${message}</center>
</body>
</html>