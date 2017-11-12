<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <!-- to work spring-mvc-form, we must include below library -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student-form</title>
</head>
<body>
	<form:form action="processform" modelAttribute="student">
		<!-- first name -->
		First Name : <form:input path="firstName"/>
		<br></br>
		
		<!-- Last Name -->
		Last Name : <form:input path="lastName"/>
		<br></br>
		
		<!-- geneder | radio buttons -->
		Gender : 
		Male   <form:radiobutton path="gender" value="Male"/>
		Female <form:radiobutton path="gender" value="Female"/>
		Others <form:radiobutton path="gender" value="Others"/>
		<br></br>
		
		<!-- Country | drop-down kind of structre -->
		Country : 
		<form:select path="country">
			<form:option value="India"  Lable="India"></form:option>
			<form:option value="Russia" Lable="Russia"></form:option>
			<form:option value="China"  Lable="China"></form:option>
			<form:option value="USA"    Lable="USA"></form:option>
		</form:select>
		<br></br>
		
		<!-- subject | checkbox -->
		Subject : 
		CSE   <form:checkbox path="subject" value="CSE"/>
		MECH  <form:checkbox path="subject" value="MECH"/>
		CIVIL <form:checkbox path="subject" value="CIVIL"/>
		E&C   <form:checkbox path="subject" value="E&C"/>
		EEE   <form:checkbox path="subject" value="EEE"/>
		<br></br>
		<!-- submit the form -->
		<form:button>submit</form:button>
	</form:form>
	
</body>
</html>