<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Register</title>
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

.input {
	width: 30px
}
</style>
</head>
<body>
	<div class="effects1">
		<h2>Item Register</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Item </span>
		</legend>
		<form:form action="update" method="POST" modelAttribute="item"
			class="effects">
			<pre>
			Id		:	<form:input path="iId" readonly="true" />
							
			Item Code	:	<form:input path="iCode" />
			
			Item UOM	:	<form:select path="uom.uomId">
							<form:option value="">--Selcet--</form:option>
							<form:options items="${uoms}" itemLabel="uomModel"
						itemValue="uomId" />
						</form:select>
			
			Dimensions	:  Width <form:input path="iWidth" cssClass="input" /> Length <form:input
					path="iLength" cssClass="input" /> Height <form:input
					path="iHeight" cssClass="input" />
						
		Item Order(SaleType)	:	<form:select path="omSaleType.id">
										<form:option value="">--Select--</form:option>
										<form:options items="${sales}" itemLabel="code" itemValue="id" />
										</form:select>
										
		Item Order(PurchaseType):	<form:select path="omPurchaseType.id">
										<form:option value="">--Select--</form:option>
										<form:options items="${purchase}" itemLabel="code"
						itemValue="id" />
										</form:select>			
							
			Base Cost	:	<form:input path="iBaseCost" />
			
			Currency	:	<form:select path="iCurrency">
							<form:option value="">--Select--</form:option>
							<form:option value="INR">INR</form:option>
							<form:option value="USD">USD</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="ERU">ERU</form:option>
						</form:select>
						<hr>
		Item Vendor 	:	
						<form:select path="venUsers"> 
							<form:options items="${vendors}" itemLabel="code" itemValue="id" />
						</form:select> 
						
		Item Customer		:	
						<form:select path="custUsers">
							<form:options items="${customers}" itemLabel="code" itemValue="id" />
						</form:select>
						
						
				<input type="submit" value="Update Item">
		</pre>
		</form:form>
	</fieldset>

	<center>${message}</center>
</body>
</html>