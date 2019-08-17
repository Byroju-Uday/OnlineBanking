<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body>

<h1 style="font-weight: bold;">Transaction Details</h1>
<form action="/transaction" method="POST" >

Transaction Type : 
		 <select name="transactiontype">
		    <option value="withdrawl">Withdrawl</option>
		    <option value="deposit">Deposit</option>
		 </select>
		<br><br>
Transaction Amount : 
		<input type="number" id="transactionamount" name="transactionamount" placeholder="Enter Amount">
		<br><br>
		
Available Balance :
		<input type="number" id="availableamount" name="availableamount" placeholder="Enter Amount">
		<br><br>

To Customer Id :
		<input type="text" id="tocustomerid" name="tocustomerid"" placeholder="Enter Customer Id">
		<br><br>
	
From Customer Id :
		<input type="text" id="fromcustomerid" name="fromcustomerid"" placeholder="Enter Customer Id">
		<br><br>

Transaction Status :
		<select name="transactionstatus">
		    <option value="pending">Pending</option>
		    <option value="failed">Failed</option>
		    <option value="done">Done</option>
		 </select>
		<br><br>				
	
		<input type="submit" id="submit" name="submit">
</form>

</body>
</html>