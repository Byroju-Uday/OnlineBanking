<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
			<table style="width:100%">
			  <tr>
			    <th><a href="/general/addCustomer"> Go to the addCustomer Page</a></th>
			    <th><a href="/general/addAccount"> Go to the addAccount Page</a></th>
			    <th><a href="/general/addTransaction"> Go to addTransaction Page</a></th>
			    
			  </tr>
			</table>
			came into addAccount
			<form action="/general/registerAccount" method="post">
				<table style="width:50%">
				  <tr>
				    <td>Enter the customer Id</th>
				    <td><input type="number" name="id" placeholder="please enter customerId of this account"/></th> 
				    
				  </tr>
				  <tr>
				    <td>accountType</td>
				    <td><input type="text" name="accountType" placeholder="please enter the accountType"/></td> 
				   
				  </tr>
				  <tr>
				    <td>accountNumber</td>
				    <td><input type="number" name="accountNumber" placeholder="please enter the AccountNo"/></td>
				  </tr>
				  <tr>
				    <td>accountBalance</td>
				    <td><input type="number" name="accountBalance" placeholder="please enter the accountBalance"/></td>
				  </tr>
				  <tr>
				    <td></td>
				    <td><input type="submit" value="submit" /></td>
				  </tr>
				</table>
		</form>
</body>
</html>