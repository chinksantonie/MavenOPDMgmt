<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Successfully created</title>
</head>
<body>
<h2>Employee Successfully created</h2>
<br>
Username - ${credentials.username}
<br>
Password - ${credentials.password}
<br>
First Name - ${employeeDetails.first_Name}
<br>
Last Name - ${employeeDetails.last_Name}
<br>
Job Type - ${employeeDetails.job_type}
<br><br>
<form action="registration">
	<input type="submit" value="create New Employee">
</form>
</body>
</html>