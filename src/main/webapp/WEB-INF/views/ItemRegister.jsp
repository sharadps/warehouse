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
	width: 40px;
}

.select1 {
	position: absolute;
	margin: auto;
	left: 10px;
	margin-left: 50px;
	padding-left: 10px;
	left: 10px;
}

.select12 {
	position: absolute;
	margin: auto;
	padding-left: 250px;
}

.btn {
	position: absolute;
	margin: auto;
}

.err {
	color: red
}
</style>
</head>
<body>
	<div class="effects1">
		<h2>Item Register</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Item</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="item"
			class="effects">
			<pre>
			Item Code	:	<form:input path="itemCode" />
						<form:errors path="itemCode" class="err" />
			Item UOM	:	<form:select path="uom.uomId">
							<form:option value="">--Selcet--</form:option>
							<form:options items="${uoms}" itemLabel="uomModel"
						itemValue="uomId" />
						</form:select>
						<form:errors path="uom" class="err" />
			Dimensions	: 	W <form:input path="iWidth" cssClass="input" name="W" /> L <form:input
					path="iLength" cssClass="input" /> H <form:input path="iHeight" cssClass="input" />
				<form:errors path="iHeight" class="err" />
						<form:errors path="iWidth" class="err" />
		Item Order(SaleType)	:	<form:select path="omSaleType.omId">
										<form:option value="">--Select--</form:option>
										<form:options items="${sales}" itemLabel="omCode"
						itemValue="omId" />
										</form:select>
						<form:errors path="omSaleType" class="err" />
		Item Order(PurchaseType):	<form:select path="omPurchaseType.omId">
										<form:option value="">--Select--</form:option>
										<form:options items="${purchase}" itemLabel="omCode"
						itemValue="omId" />
										</form:select>
						<form:errors path="omPurchaseType" class="err" />
			Base Cost	:	<form:input path="iBaseCost" />
							<form:errors path="iBaseCost" class="err" />
			Currency	:	<form:select path="iCurrency">
							<form:option value="">--Select--</form:option>
							<form:option value="INR">INR</form:option>
							<form:option value="USD">USD</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="ERU">ERU</form:option>
						</form:select>
						<form:errors path="iCurrency" class="err" />
			Item Vendor 	:
						<form:select path="venUsers"> 
						<form:options items="${vendors}" itemLabel="whCode"
						itemValue="whId" />
						</form:select>
						<form:errors path="venUsers" class="err" />
			Item Customer	:	
						<form:select path="custUsers">
							<form:options items="${customers}" itemLabel="whCode"
						itemValue="whId" />
						</form:select>
						<form:errors path="custUsers" class="err" />
				
				<input type="submit" value="Create Item" class="btn">
			</pre>
		</form:form>
	</fieldset>

	<center>${message}</center>
</body>
</html>