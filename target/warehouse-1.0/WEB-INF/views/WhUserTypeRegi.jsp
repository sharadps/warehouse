<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	background-color:  #660033;
	border: 1px solid black;
	width: 800px;
	margin: auto;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
	color:white  
}

.effects {
	background-color:  #7ABA7A;
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
	background-color:  #7ABA7A;
}

.legend2 {
	position: absolute;
	bottom: -1.4ex;
	left: 10px;
	background: white
}
caption, .legend2 {
	padding: 0 2px
}</style>
</head>
<body>
	<div class="effects1">
		<h2>WhUser Type Registration</h2>
	</div>
	<fieldset>
	<legend>
			<span class=legend2>WhUserType</span>
		</legend>
	<form:form action="insert" method="POST" modelAttribute="whty" class="effects">
		<pre>
			User Type	:	<form:radiobutton path="whtype" value="vendor" />Vendor
						<form:radiobutton path="whtype" value="customer" />Customer<br />
			User Code	:	<form:input path="code" />
			<br />
			Users For	:	<form:input path="forType" />
			<br />
			User Email	:	<form:input path="email" />
			<br />
			User Contact	:	<form:input path="contact" />
			<br />
			User Id Type	:	<form:select path="idType">
								<form:option value="">--Select--</form:option>
								<form:option value="pan">PAN CARD</form:option>
								<form:option value="adhar">ADHAR CARD</form:option>
								<form:option value="voter">VOTER ID</form:option>
								<form:option value="other">OTHER</form:option>
							</form:select>
			<br />
			*If Other	:	<form:input path="ifOther" />
			<br />
			Id Number	:	<form:input path="idNumber" />
			<br />
			<input type="submit" value="Create User">
		</pre>
	</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>