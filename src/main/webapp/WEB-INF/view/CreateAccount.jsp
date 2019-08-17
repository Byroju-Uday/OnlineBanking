<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Account</title>
    <style>
    .error{
        color:red;
        font-size: 15px;
        padding:10px;
    }
    </style>
</head>
<body>

<form:form action="/forms/register" method="POST" modelAttribute="account">
    <div class="form-group">
    
        <label>AccountType:</label><form:input path="accountType" size="30" cssClass="form-control" placeholder="Enter Account Type" />
        <small><form:errors path="accountType" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <label>AccountNumber:</label><form:input path="accountNumber" cssClass="form-control" placeholder="Enter Account Number" />
        <small><form:errors path="accountNumber" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <label>Account Balance:</label><form:input path="accountBalance" cssClass="form-control" placeholder="Enter Account Balance" />
        <small><form:errors path="accountBalance" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <button type="submit" >Submit</button>
    </div>
</form:form>

</body>
</html>