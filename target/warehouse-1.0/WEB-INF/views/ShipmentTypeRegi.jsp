<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2 {
	text-align: center;
}

.effects1 {
	background-color: #660033;
	border: 1px solid black;
	width: 800px;
	margin: auto;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
	color: white
}

.effects {
	background-color: #7ABA7A;
	/* border: 1px solid; */
	width: 700px;
	margin: auto;
	margin-top: 0px;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
}

fieldset {
	position: relative;
	margin: auto;
	padding: 0.35em 0.625em 0.75em;
	width: 600px;
	background-color: #7ABA7A;
}

.legend2 {
	position: absolute;
	bottom: -1.4ex;
	left: 10px;
	background: white
}

caption, .legend2 {
	padding: 0 2px
}
</style>
</head>
<body>
	<div class="effects1">
		<h2>ShipmentType</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>UOM</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="stype"
			cssClass="effects">
			<pre>
			Shipment Type	:	<form:select path="stmode">
								<form:option value="">-- Select --</form:option>
								<form:option value="air">Air</form:option>
								<form:option value="truck">Truck</form:option>
								<form:option value="ship">Ship</form:option>
								<form:option value="train">Train</form:option>
								</form:select>		<br />
			Shipment Code	:	<form:input path="code" />
			<br />
			
			Enable Shipment	:	<form:checkbox path="enabled" value="yes" />Yes
			<br />
			Shipment Grade	:	<form:radiobutton path="grade" value="a" />A
								<form:radiobutton path="grade" value="b" />B
								<form:radiobutton path="grade" value="c" />C<br />
			Description		:	<form:textarea path="dsc" />
				<br />
			
			<input type="submit" value="Create Shipment">
		
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>