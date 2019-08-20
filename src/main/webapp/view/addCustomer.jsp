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
			Please add the Customer
			<form action="/general/registerCustomer" method="post">
				<table style="width:50%">
				  <tr>
				    <td>Customer Name</th>
				    <td><input type="text" name="customerName" placeholder="please enter the name"/></th> 
				    
				  </tr>
				  <tr>
				    <td>Password</td>
				    <td><input type="password" name="password" placeholder="please enter the password"/></td> 
				   
				  </tr>
				  <tr>
				    <td>PhoneNo</td>
				    <td><input type="number" name="phoneNo" placeholder="please enter PhoneNo"/></td>
				  </tr>
				  <tr>
				    <td>DOB</td>
				    <td><input type="date" name="dob" placeholder="please enter the DOB"/></td>
				  </tr>
				  <tr>
				    <td>Aadhar No</td>
				    <td><input type="number" name="aadharNo" placeholder="please enter AadharNo"/></td>
				  </tr>
				  <tr>
				    <td>PanCard No</td>
				    <td><input type="text" name="pancardNo" placeholder="please enter the panCard No"/></td>
				  </tr>
				  <tr>
				    <td>EmailId</td>
				    <td><input type="text" name="emailId" placeholder="please enter the EmailId"/></td>
				  </tr>
				  <tr>
				    <td>address</td>
				    <td><input type="text" name="address" placeholder="please enter the address"/></td>
				  </tr>
				  <tr>
				    <td></td>
				    <td><input type="submit" value="submit" /></td>
				  </tr>
				</table>
		</form>
</body>
</html>