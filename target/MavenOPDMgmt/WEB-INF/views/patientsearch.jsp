<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Search</title>
</head>
<body>
   <h1>Patient Search</h1><br>
  	<sf:form action="patientdetails" commandName="patientsearch">
	    Patient ID: <sf:input path="patient_det_no" /> <br>
	    First Name: <sf:input path="first_Name" /><br>
	    Last Name: <sf:input path="last_Name" /><br>
	    House Name:<sf:input path="houseName"/><br>
    	<input type="submit"><br>
  	</sf:form>
</body>
</html>