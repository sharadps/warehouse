<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WHUserType</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//default background color is grey
		$('#whIfOther').css('background-color', '#DCDCDC');

		//on click radio button user type-execute this
		$("input[type=radio][name=whType]").click(function() {
			if (this.value == 'vendor') {
				$("#whForType").val("Purchase");
			} else if (this.value == 'customer') {
				$("#whForType").val("Sale");
			}
		});

		//on change dropdown value of user id type
		$("#whIdType").change(function() {
			var opt = $("#whIdType").val();
			if (opt != 'OTHER') {
				$('#whIfOther').attr('readonly', true);
				$('#whIfOther').css('background-color', '#DCDCDC');
				$('#whIfOther').val("");
			} else {
				$('#whIfOther').attr('readonly', false);
				$('#whIfOther').css('background-color', '#FFFFFF');
			}
		});
	});
</script>
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
		<h2>WhUser Type Registration</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>WhUserType</span>
		</legend>
		<form:form action="insert" method="POST" modelAttribute="whtyuser"
			class="effects">
			<pre>
			User Type	:	<form:radiobutton path="whType" value="vendor" />Vendor <form:radiobutton
					path="whType" value="customer" />Customer
						<form:errors path="whType" class="err" />
			User Code	:	<form:input path="whCode" placeholder="Enter Code" />
						<form:errors path="whCode" class="err" />
				
			Users For	:	<form:input path="whForType" placeholder="Enter user for" />
				
			 Email		:	<form:input path="whEmail" placeholder="Enter Email" />
						<form:errors path="whEmail" class="err" />
				
			 Contact	:	<form:input path="whContact"
					placeholder="Enter Contact Number" />
						<form:errors path="whContact" class="err" />
				
			 Id Type	:	<form:select path="whIdType">
								<form:option value="">--Select--</form:option>
								<form:option value="PAN CARD">PAN CARD</form:option>
								<form:option value="ADHAR CARD">ADHAR CARD</form:option>
								<form:option value="VOTER ID">VOTER ID</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
						<form:errors path="whIdType" class="err" />
				
			*If Other	:	<form:input path="whIfOther" />
		
			Id Number	:	<form:input path="whIdNumber"
					placeholder="Enter Id Number" />
						<form:errors path="whIdNumber" class="err" />
				
					
					<input type="submit" value="Create User">
		</pre>
		</form:form>
	</fieldset>
	<center>${message}</center>
</body>
</html>