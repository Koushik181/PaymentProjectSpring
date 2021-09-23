<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<c:if test="${sessionScope.custemail == null }">
		<c:redirect url="/login"></c:redirect>
	</c:if>
	<div class='container'>
		<div> Name : ${sessionScope.cust.customerName }</div>
		<div> Address : ${sessionScope.cust.customerAddress }</div>
		<div> Identity Type : ${sessionScope.cust.customerIdentity }</div>
	
	</div>
	<a href='/logout'>Logout</a>
</body>
</html>	