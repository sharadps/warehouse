<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PurchaseOrder</title>
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
		<h2>Purchase Order</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>Purchase Order</span>
		</legend>
		<form:form action="update" method="POST" modelAttribute="po"
			class="effects">
			<pre>
			Id		:	<form:input path="purchaseId" readonly="true" />
			
		Order Code		:	<form:input path="purchaseCode" />
								<form:errors path="purchaseCode" class="err" />
		Shipment Code		:	<form:select path="purchaseshipCode.shipId">
								<form:option value="">--Select--</form:option>
								<form:options items="${shipcode}" itemLabel="shipCode"
						itemValue="shipId" />
								</form:select>
								<form:errors path="purchaseshipCode" class="err" />
		Vendor			:	<form:select path="purchaseVendor">
								<form:option value="">--Select--</form:option>
								<form:options items="${vendorr}" itemLabel="whCode"
						itemValue="whId" />
								</form:select>
								<form:errors path="purchaseVendor" class="err" />
		Reference Number	:	<form:input path="purchaseRefno" />
								<form:errors path="purchaseRefno" class="err" />
		 Quality Check		:	<form:radiobutton path="purchaseQcheck"
					value="Required" />Required<form:radiobutton path="purchaseQcheck"
					value=" Not Required" />Not Required
								<form:errors path="purchaseQcheck" class="err" />
				
		Default Status		:	<form:input path="purchaseDefStatus" value="Open"
					readonly="true" />
									<form:errors path="purchaseDefStatus" class="err" />
		
		Description		:	<form:input path="purchaseDsc" />
								<form:errors path="purchaseDsc" class="err" />
					
					<input type="submit" value="Place Order">
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>