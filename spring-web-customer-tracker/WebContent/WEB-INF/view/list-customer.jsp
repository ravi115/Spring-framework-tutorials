<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer data</title>
		<!-- add support for style sheet -->
		
		<link type="text/css" 
				rel="stylesheet" 
				href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Relationship manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<!-- put a button: add customer -->
		<input type="button" value="Add Customer" 
			onClick="window.location.href='showFormForAdd'; return false;"
			class = "add-button"
		/> 
		<!-- add html table here -->
		<table>
			<tr>
				<th>FirstName </th>
				<th>LastName </th>
				<th>Email </th>
				<th>Action </th>
			</tr>
			<!-- loop over and print our customer -->
			<c:forEach var = "cust" items="${customers}">
			
			<!-- construct a update link with customer id -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${cust.id}"></c:param>
			</c:url>
			
			<!-- construct a delete with customer id -->
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${cust.id}"></c:param>
			</c:url>
			
				<tr>
					<td>${cust.firstName}</td>
					<td>${cust.lastName}</td>
					<td>${cust.email}</td>
					<td>
					<!-- display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						onclick="if (!(confirm('Are you sure want to delete this customer ?'))) return false" >
						Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>