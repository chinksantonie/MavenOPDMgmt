<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.pckg.opd.dao.EmployeeDetailsDao"%>
<%@ page import="com.pckg.opd.hibernate.EmployeeDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="css/style_reg.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    <link rel="stylesheet" href="css/opd.css" media="screen" type="text/css" />
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
			<h2 style="text-align: center"><strong>EMPLOYEE REGISTRATION</strong></h2>
            <div class="freshdesignweb-top">
            
                <span class="right">
                    <a href="login">
                        <strong>LOGOUT</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div>
      <div  class="form">
    	<sf:form commandName="employeeDetails" action="insertEmployee"> 
    		<sf:errors path="*" cssClass="error"></sf:errors>
    			<p class="contact"><label for="name">First Name</label><label style="color:red">*</label></p> 
    			<sf:input path="first_Name" placeholder="First name" required="true"/> 
    			
    			<p class="contact"><label for="name">Middle Name</label></p> 
    			<sf:input path="middle_Name" placeholder="Middle name"/>
    			
    			<p class="contact"><label for="name">Last Name</label></p> 
    			<sf:input path="last_Name" placeholder="Last name"/>
    			
    			<p class="contact"><label for=job_type>Job Type</label></p>
    			<sf:select path="job_type" cssClass="select-style gender">
    				<sf:option value="RECEPTIONIST">RECEPTIONIST</sf:option>
    				<sf:option value="DOCTOR">DOCTOR</sf:option>
    			</sf:select>
    			<br/><br/>
    			
    			<p class="contact"><label for="housename">House Name</label><label style="color:red">*</label></p> 
    			<sf:input path="houseName" placeholder="House Name" required=""/> 
                
                <p class="contact"><label for="street">Street</label></p> 
    			<sf:input path="street" placeholder="Street"/>
    			
    			<p class="contact"><label for="city">City</label></p> 
    			<sf:input path="city" placeholder="City"/>
    			
    			<p class="contact"><label for="pincode">Pincode</label></p>
    			<sf:input id="pincode" path="pincode" placeholder="Pincode"/> 
    			
    			<br/><br/>
	            
	            <%-- <sf:select class="select-style gender" path="job_type">
	            <option value="select">Employee Type</option>
	            <option value="d">Doctor</option>
	            <option value="r">Receptionist</option>
	            <option value="a">Admin</option>
	            </sf:select><br/><br/>--%>
            <input class="buttom" name="submit" id="submit" value="Register now!" type="submit"> 	       
	
	</sf:form>
	</div>
</div>
</body>
</html>