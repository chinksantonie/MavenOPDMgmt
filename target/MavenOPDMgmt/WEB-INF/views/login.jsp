<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.pckg.opd.dao.CredentialsDao"%>
<%@ page import="com.pckg.opd.hibernate.Credentials"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Log-in</title>


    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="css/opd.css" media="screen" type="text/css" />

</head>

<body>

  <div class="login-card">
    <h1>Log-in</h1><br>
  <sf:form action="authorize" commandName="logindata">
  <sf:errors path="*" cssClass="error"></sf:errors>
    <sf:input path="username" placeholder="Username"/>
    <sf:password path="password" placeholder="Password"/>
    <input type="submit">
  </sf:form>
<%--
  <div class="login-help">
    <a href="#">Register</a>  <a href="#">Forgot Password</a>
  </div>
  --%>
</div>
</body>
</html>