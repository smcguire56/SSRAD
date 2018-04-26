<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/style.css" rel="stylesheet"></link>

<title>Create Order</title>
</head>
<body>
	<h1>Create Order</h1>
	
	<form:form modelAttribute="orderInfo">
 		<table>
			<tr>
				<td>Ship Name: </td>
				<td><form:select path="ship" items="${shipList}" /></td>
			</tr>
			<tr>
				<td>Shipping Company: </td>
				<td><form:select path="shippingCompany" items="${shippingCompanyList}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
		</table> 
	</form:form>
	<a href="/index.html">Home</a></body>
</html>