<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultation Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_reg.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/opd.css" media="screen"  />
</head>
</head>
<body>
				<h1>Consultation Details</h1>
      <div  class="form">
      	<sf:form commandName="paymentDetails" action="${pageContext.request.contextPath}/saveconsultation"> 
      		<sf:errors path="*" cssClass="error"></sf:errors>
 
    			<p class="contact"><label for="patientid">Patient Id</label></p>
    			<sf:input path="patientID" placeholder="Patient Id" value="${patientID}" required="true"/> 
    			
    			<p class="contact"><label for="doctorid">Doctor Id</label></p> 
    			<sf:select path="doctorName" items="${doctors}" />
    			 
    			<p class="contact"><label for="billid">Consultation Fees</label></p> 
    			<sf:input path="consultation_Fees"/>
    			
    			<p class="contact"><label for=job_type>Payment Status</label></p>
    			<sf:select path="payment_Status" cssClass="select-style gender">
    				<sf:option value="Y">Paid</sf:option>
    				<sf:option value="N">Not Paid</sf:option>
    			</sf:select>
    			<br/><br/>
    			
    			<input class="buttom" name="submit" id="submit" value="Submit" type="submit"> 	       
   </sf:form>
</div>      
</body>
</html>