<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
</head>
<body>
<h1>Patient Details</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Patient Id</th><th>First Name</th><th>Last Name</th><th>House Name</th><th>Edit</th><th>Consult Doctor</th></tr>  
   <c:forEach var="patient" items="${patientDetails}">   
   <tr>  
   <td>${patient.patient_det_no}</td>  
   <td>${patient.first_Name}</td>  
   <td>${patient.last_Name}</td>  
   <td>${patient.houseName}</td>  
   <td><a href="editpatient/${patient.patient_det_no}">Edit</a></td> 
   <td><a href="addconsultant/${patient.patient_det_no}">Consult</a></td> 
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="patientform">Add New Patient</a> 
   <a href="patientsearch">Search patient</a>
</body>
</html>



  
