<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student confirmation</title>
</head>
<body>
	<p style='color:green; font-size:35px;'>-------Student confirmation page----</p>
	Welcome ${student.firstName} ${student.lastName}
	<br></br>
	Gender : ${student.gender}
	<br></br>
	Country : ${student.country}
	<br></br>
	enrolled into subject : 
	<ul>
		<c:forEach var="temp" items="${student.subject}">
		<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>