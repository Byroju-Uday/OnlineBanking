<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container" id="registration">
<h1>Customer Registration</h1>
	<form action="/employee/register" method="POST" modelattribute="customer">
	<div class="form-row">
	<div class="form-group col-md-6">
      <label for="customerId">CustomerId</label>
      <input type="number" class="form-control" name = "customerId" id="customerId" placeholder="CustomerId">
    </div>
    <div class="form-group col-md-6">
      <label for="customerName">CustomerName</label>
      <input type="text" class="form-control" name = "customerName" id="customerName" placeholder="CustomerName">
    </div>
    <div class="form-group col-md-6">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password" id="password" placeholder="Password">
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-6">
      <label for="emailId">Email</label>
      <input type="email" class="form-control" id="emailId" name="emailId" placeholder="Email">
     </div>
    <div class="form-group col-md-6">
      <label for="dob">DOB</label>
      <input type="date" class="form-control" id="dob" name="dob" placeholder="Date of Birth">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress"  name="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="aadharNo">Aadhar Card</label>
      <input type="number" class="form-control" id="aadharNo" name="aadharNo" placeholder="Aadhar Card">
    </div>
    
    <div class="form-group col-md-4">
      <label for="pancardNo">Pan Card</label>
      <input type="text" class="form-control" id="pancardNo" name="pancardNo" placeholder="Pan Card">
    </div>
     <div class="form-group col-md-4">
      <label for="phoneNo">Phone Number</label>
      <input type="number" class="form-control" id="phoneNo" name="phoneNo" placeholder="Phone Number">
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Register</button>
</form>
<button align="right" type="submit" class="btn btn-primary">OpenAccount</button>
</div>
</body>
</html>