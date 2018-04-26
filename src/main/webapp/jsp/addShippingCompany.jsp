<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/style.css" rel="stylesheet"></link>

<title>Add Shipping Company List</title>
</head>
<body>
	<h1>Add Shipping Company</h1>
	
	<form:form modelAttribute="shippingCompany">
		<table>
			<tr>
				<td>Shipping Company Name </td>
				<td><form:input path="name"></form:input></td>
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td>Home Port </td>
				<td><form:input path="homePort"></form:input></td>
				<td><form:errors path="homePort"></form:errors></td>
			</tr>	
			<tr>
				<td>Balance </td>
				<td><form:input path="balance"></form:input></td>
				<td><form:errors path="balance"></form:errors></td>
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