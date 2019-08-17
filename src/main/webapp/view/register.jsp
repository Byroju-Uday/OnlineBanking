<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" id="login">
<h1>Customer Registration</h1>
	<form action="/users/register" method="POST" >
	<div class="form-row">
    <div class="form-group col-md-6">
      <label for="customerName">CustomerName</label>
      <input type="text" class="form-control" id="customerName" placeholder="CustomerName">
    </div>
    <div class="form-group col-md-6">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Password">
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-6">
      <label for="emailId">Email</label>
      <input type="email" class="form-control" id="emailId" placeholder="Email">
     </div>
    <div class="form-group col-md-6">
      <label for="dob">DOB</label>
      <input type="date" class="form-control" id="dob" placeholder="Date of Birth">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="aadharNo">Aadhar Card</label>
      <input type="number" class="form-control" id="aadharNo" placeholder="Aadhar Card">
    </div>
    
    <div class="form-group col-md-4">
      <label for="pancardNo">Pan Card</label>
      <input type="text" class="form-control" id="pancardNo" placeholder="Pan Card">
    </div>
     <div class="form-group col-md-4">
      <label for="phoneNo">Phone Number</label>
      <input type="number" class="form-control" id="phoneNo" placeholder="Phone Number">
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>
</body>
</html>