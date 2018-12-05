<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Register</title>
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
		<h2>Customer Registration</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Customer</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="cust"
			class="effects">
			<pre>
			Customer Code	:	<form:input path="custCode" placeholder="Enter Code" /><form:errors path="custCode" cssClass="err" />
				
			 Address	:	
			 			<form:textarea path="custAddress" placeholder="Enter Address" /><form:errors path="custAddress" cssClass="err" />

			Location	:
						<form:select path="custLocs" multiple="true">
						 	<form:option value="Pune">Pune</form:option>
						 	<form:option value="Hyderabad">Hyderabad</form:option>
						 	<form:option value="Bangalor">Bangalor</form:option>
						 	<form:option value="Mumbai">Mumbai</form:option>
					</form:select><form:errors path="custLocs" cssClass="err" />
				
							
			Enabled		:	 <form:radiobutton path="custEnabled" value="yes" />YES <form:radiobutton
					path="custEnabled" value="no" />NO
						 
			Email		:	<form:input path="custEmail" placeholder="Enter Email" /><form:errors path="custEmail" cssClass="err" />
		
			Contact		:	<form:input path="custContact" placeholder="Enter Contact" /><form:errors path="custContact" cssClass="err" />
				
			<input type="submit" value="Customer Register">
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>