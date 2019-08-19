<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Transactions</h1>

<table border="1">
    <tr>
        <th> Id</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${transactions}" var="transaction">
        <tr>
            <td>${transaction.transactionId}</td>
            <td>${transaction.status}</td>

        </tr>
    </c:forEach>
</table>


</body>
</html>