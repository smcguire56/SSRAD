<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/style.css" rel="stylesheet"></link>

<title>Insert title here</title>
</head>
<body>
	<h1>Ships</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
		</tr>

		<c:forEach items="${shippingCompanies}" var="ship">

			<tr>
			<!-- shipping_company (scid, balance, home_port, name) -->
			<!-- sid, cost, name, passengers, metres, scid -->
				<td>${ship.name}</td>
				<td>${ship.homePort}</td>
				<td>${ship.balance}</td>
				<td>${ship.ships}</td>
			</tr>

		</c:forEach>

	</table>
	<a href="/index.html">Home</a>
</body>
</html>