<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor confirmation page</title>
</head>
<body bgcolor="blue">

	<p style="color:red; background-color:yellow;font-size:20px">
	This HTML Form will be implement using following ways: - 
	<ul>
		<li>drop-down using properties file in java class</li>
		<li>drop-down using HashMap concept in java class</li>
		<li>radio-button using HashMap concept in java class</li>
	</ul>
	</p>
	<p style="color:yellow; font-size:25px;">details</p>
		Welcome ${professor.firstName} ${professor.lastName}
		<br/>
		Gender : ${professor.gender }
		<br/>
		Country: ${professor.country }
		<br/>
		courses teach :
		<ul>
			<c:forEach var="temp" items="${professor.courses}">
			
			<li>${temp}</li>
			</c:forEach>
		</ul>
		<br/>
	Batch-timings : ${professor.batchTiming }
</body>
</html>