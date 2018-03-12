<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_reg.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/opd.css" media="screen"  />
</head>
<body>
	<h2 style="text-align: center"><strong>ADD NEW PATIENT</strong></h2>
    <div class="freshdesignweb-top">
        
            <span class="right">
                <a href="${pageContext.request.contextPath}/login">
                    <strong>LOGOUT</strong>
                </a>
            </span>
            <div class="clr"></div>
        </div>
      <div  class="form">
    	<sf:form commandName="patientDetails" action="${pageContext.request.contextPath}/insertPatient"> 
    		<sf:errors path="*" cssClass="error"></sf:errors>
    			<sf:hidden path="patient_det_no" />
    			<p class="contact"><label for="name">First Name</label><label style="color:red">*</label></p> 
    			<sf:input path="first_Name" placeholder="First name" required="true"/> 
    			
    			<p class="contact"><label for="name">Middle Name</label></p> 
    			<sf:input path="middle_Name" placeholder="Middle name"/>
    			
    			<p class="contact"><label for="name">Last Name</label></p> 
    			<sf:input path="last_Name" placeholder="Last name"/>
    			
    			<p class="contact"><label for="housename">House Name</label><label style="color:red">*</label></p> 
    			<sf:input path="houseName" placeholder="House Name" required=""/> 
                
                <p class="contact"><label for="street">Street</label></p> 
    			<sf:input path="street" placeholder="Street"/>
    			
    			<p class="contact"><label for="city">City</label></p> 
    			<sf:input path="city" placeholder="City"/>
    			
    			<p class="contact"><label for="pincode">Pincode</label></p>
    			<sf:input id="pincode" path="pincode" placeholder="Pincode"/> 
    			
    			<br/><br/>

            <input class="buttom" name="submit" id="submit" value="Register now!" type="submit"> 	       
	
	</sf:form>
	</div>
</body>
</html>