<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Method</title>
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

.err {
	color: red;
}
</style>
</head>
<body>
	<div class="effects1">
		<h2>Order Model</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Order Model</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="om"
			class="effects">
			<pre>
			Order Mode	:	<form:radiobutton path="omModel" value="sale" />Sale <form:radiobutton
					path="omModel" value="purchase" />Purchase <form:errors
					path="omModel" class="err" />
					
			Order Code	:	<form:input path="omCode" />
				<form:errors path="omCode" class="err" />
				
			Order Method	:	<form:select path="omMethod">
							<form:option value="">-- Select --</form:option>
							<form:option value="fifo"> FIFO</form:option>
							<form:option value="lifo">LIFO</form:option>
							<form:option value="fcfo">FCFO</form:option>
							<form:option value="fefo">FEFO</form:option>
							</form:select>
				<form:errors path="omMethod" class="err" />
				
			<br />
			Order Accept	:	<form:checkbox path="omAcceptt" value="multi-model" />Multi-Model
						<form:checkbox path="omAcceptt" value="accept-return" />Accept-Return
						<form:errors path="omAcceptt" cssClass="err" />
						
			Description	:	<form:textarea path="omDsc" class="err" />
				<form:errors path="omDsc" class="err" />
			
			<input type="submit" value="Create Order Method">
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>