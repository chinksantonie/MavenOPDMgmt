<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<br><br><br>

<h2>Patient ${patientDetails.first_Name} ${patientDetails.middle_Name} ${patientDetails.last_Name} successfully created with patient ID - ${patientDetails.patient_det_no}</h2>
<br>

<br><br><br>
<form action="patientsearch">
	<input type="submit" value="search patient">
</form>
</body>
</html>