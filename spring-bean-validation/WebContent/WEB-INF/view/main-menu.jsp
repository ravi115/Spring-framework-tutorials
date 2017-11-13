<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Tutorials</title>
<link rel="stylesheet" type="text/css"           

           href="${pageContext.request.contextPath}/resources/css/my-test.css"/>

<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
	<img src="${pageContext.request.contextPath}/resources/images/monu.jpg" />
	<h2>Spring-mvc-demo tutorials</h2>
	<hr/>
	<a href="showform">Hello world form</a><br/>
	<a href="student/showform">go to student registration page</a><br/>
	<a href="professor/showform">go to professor registration page</a><br/>
	<a href="customer/showform">go to customer registration page</a><br/>
</body>
</html>