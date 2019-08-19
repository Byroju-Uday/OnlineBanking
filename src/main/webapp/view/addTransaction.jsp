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
			Came into addTransaction
			<form action="/general/registerTransaction" method="post">
				<table style="width:50%">
				  <tr>
				    <td>Enter the Type of Transaction</th>
				    <td><input type="text" name="typeOfTransaction" placeholder="please enter Type of Transaction"/></th> 
				    
				  </tr>
				  <tr>
				    <td>Transaction Amount</td>
				    <td><input type="number" name="transactionAmount" placeholder="please enter Transaction Amount"/></td> 
				   
				  </tr>
				  <tr>
				    <td>From Account Id</td>
				    <td><input type="number" name="fromAccountId" placeholder="please enter the From Account Id"/></td>
				  </tr>
				  <tr>
				    <td>To Account Id</td>
				    <td><input type="number" name="toAccountId" placeholder="please enter the To Account Id"/></td>
				  </tr>
				  <tr>
				    <td></td>
				    <td><input type="submit" value="submit" /></td>
				  </tr>
				</table>
		</form>
</body>
</html>