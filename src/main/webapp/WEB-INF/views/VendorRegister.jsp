<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Register</title>
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
	color: red
}
</style>
</head>
<body>
	<div class="effects1">
		<h2>Vendor Register</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Vendor</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="vendor"
			class="effects">
			<pre>
			Name		:	<form:input path="venName" placeholder="Enter Name" /><form:errors path="venName" class="err" />
				
			
			Code		:	<form:select path="venCode">
						<form:option value="">--Select--</form:option>
						<form:option value="CAT">CAT</form:option>
						<form:option value="RES">RES</form:option>
						</form:select><form:errors path="venCode" class="err"/>
				
			Designation	:	<form:radiobutton path="venDesg" value="sales" />Sales <form:radiobutton
					path="venDesg" value="service" />Service <form:radiobutton
					path="venDesg" value="both" />Both <form:errors path="venDesg" class="err"/>					
		
			Preserve	:	<form:checkbox path="venPreserve" value="A" />A <form:checkbox
					path="venPreserve" value="B" />B <form:checkbox path="venPreserve"
					value="C" />C
							
					<input type="submit" value="Vendor Register">			
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>