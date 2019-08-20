<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Add Account</title>
<style>
.error {
	color: red;
	font-size: 15px;
	padding: 10px;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
<h1 class="display-4" align="center">Account Details</h1>
<div class="container" id="AddAccount">
	<form:form action="/employee/createaccount" method="POST" modelAttribute="account">
	    <div class="form-row">
		<div class="form-group col-md-6">
			<label for="accountType">Account Type</label> 
			<form:select path="accountType"
				class="form-control" id="accountType">
				<option >Savings Account</option>
				<option>Current Account</option>
				<option>Salary Account</option>
			</form:select>
		</div>
		</div>
		<div class="form-row">
		<div class="form-group col-md-6">
			<label for="accountNumber">Account Number</label> <form:input
				path="accountNumber" type="number" class="form-control" id="accountNumber"
				placeholder="Enter Account Number"/>
		</div>
		<div class="form-group col-md-6">
			<label for="accountBalance">Account Balance</label> <form:input
				path="accountBalance" type="number" class="form-control" id="accountBalance"
				placeholder="Enter Account Balance"/>
		</div>
		</div>
		<button type="submit" class="btn btn-primary">Create Account</button>
	</form:form>
</div>
</body>
</html>