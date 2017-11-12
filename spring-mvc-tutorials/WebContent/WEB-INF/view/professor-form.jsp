<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <!-- to work spring-mvc-form, we must include below library -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor confirmation page</title>
</head>
<body>
	<p>Professor Registration Page</p>
	<form:form action="processform" modelAttribute="professor">
		<!-- first name -->
		First Name : <form:input path="firstName"/>
		<br></br>
		
		<!-- Last Name -->
		Last Name : <form:input path="lastName"/>
		<br></br>
		
		<!-- geneder | radio buttons -->
		Gender : <form:radiobuttons path="gender" items="${professor.genderOptions}"/>
		<br></br>
		
		<!-- Country | drop-down kind of structre -->
		Country : 
		<form:select path="country">
			<form:options items="${professor.countryOptions}"/>
			</form:select>
		<br></br>
		
		<!-- subject | checkbox -->
		Courses : 
		JAVA <form:checkbox path="courses" value="JAVA" />
		C#   <form:checkbox path="courses" value="C#" />
		PHP  <form:checkbox path="courses" value="PHP" />
		<br></br>
		
		<!-- batch Timings | properties file to drop-down -->
		<form:select path="batchTiming">
			<form:options items="${batchtime}"/>
		</form:select>
		<br></br>
		
		<!-- submit the form -->
		<form:button>submit</form:button>
	</form:form>
	
</body>
</html>