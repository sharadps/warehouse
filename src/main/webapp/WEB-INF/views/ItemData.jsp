<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<title>Item Data</title>
<style type="text/css">
/* .anch {
	background-color: magneta;
	width: 700px;
	position: relative;
	margin: auto;
}

.tab {
	position: relative;
	margin: auto;
	background-color: #7ABA7A;
	 border: 1px solid; 
	width: 900px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
}

.effects {
	background-color: #660033;
	border: 1px solid black;
	width: 1000px;
	margin: auto;
	font-weight: bold;
	font-size: 15px;
	font-weight: bold;
	color: white
}

h2 {
	text-align: center;
} */
.custom {
	background-color: #7ABA7A;
}

.customtab {
	background-color: #660033;
}

.cards {
	padding-top: 1px;
	background-color: 537C89;
}

.excelp {
	
}
</style>
</head>
<body>
	<!-- <div class="effects">
		<h2>Item Data</h2>
	</div> -->
	<div class="container">
		<div class="card-header customtab text-white">
			<h2 class="text-center">Order Model Data</h2>
		</div>
		<div class="card-body cards">
			<table class="table table-hover text-center custom table-bordered">
				<thead class="thead-dark">
					<tr class="bg-dark text-white">
					<th>ID</th>
					<th>CODE</th>
					<th>DIAMENSIONS</th>
					<th>SALE</th>
					<th>PURCHASE</th>
					<th>VENDOR</th>
					<th>CUSTOMER</th>
					<th>BASE COST</th>
					<th>CURRENCY</th>
					<th>UomModele</th>

					<th colspan="2">OPERATION</th>
				</tr>
				</thead>
				<c:forEach items="${list}" var="item">
					<tr>
						<td><c:out value="${item.iId}"></c:out></td>
						<td><c:out value="${item.itemCode}"></c:out></td>
						<td>W: <c:out value="${item.iWidth}"></c:out> L: <c:out
								value="${item.iLength}"></c:out> H: <c:out
								value="${item.iHeight}"></c:out></td>
						<td><c:out value="${item.omSaleType.omCode}"></c:out></td>
						<td><c:out value="${item.omPurchaseType.omCode}"></c:out></td>
						<td><c:forEach items="${item.venUsers}" var="ven">
								<c:out value="${ven.whCode}"></c:out>
							</c:forEach></td>
						<td><c:forEach items="${item.custUsers}" var="cust">
								<c:out value="${cust.whCode}"></c:out>
							</c:forEach></td>
						<td><c:out value="${item.iBaseCost}"></c:out></td>
						<td><c:out value="${item.iCurrency}"></c:out></td>
						<td><c:out value="${item.uom.uomModel}"></c:out></td>
						<td><a class="btn btn-success" href="edit?id=${item.iId}"><i
								class="fa fa-pencil"></i>Edit</a></td>
						<td><a class="btn btn-danger" href="delete?id=${item.iId}"><i
								class="fa fa-trash-o fa-lg"></i> Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<center>
		<a class="btn btn-success" href="excel">Generate Excel</a>   <a class="btn btn-success" href="pdf">Generate Pdf</a>
	</center>

	<center>${message}</center>
</body>
</html>