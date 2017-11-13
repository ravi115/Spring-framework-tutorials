<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <!-- to work spring-mvc-form, we must include below library -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer registration form</title>
	<style type="text/css">
		.error {color:red}
	
	</style>
</head>
<body>
	<p><i>Fill out the form (*). means required</i></p>
	<form:form action="processform" modelAttribute="customer">
	
		First Name : <form:input path="firstName"/>
					<form:errors path="firstName" cssClass="error"></form:errors>	
		<br/>
		LastName : <form:input path="lastName"/>
					<form:errors path="lastName" cssClass="error"></form:errors>
		<br/>
		FreePasses : <form:input path="freePasses"/>
					<form:errors path="freePasses" cssClass="error"></form:errors>
		<br/>
		Postal Code: <form:input path="postalCode"/>
					 <form:errors path="postalCode" cssClass="error"></form:errors>
		<br/> 
		Test My Custom Code: <form:input path="myCustomeAnnotation"/>
					 <form:errors path="myCustomeAnnotation" cssClass="error"></form:errors>
		<br/> 
		<form:button>submit</form:button>
	</form:form>
</body>
</html>