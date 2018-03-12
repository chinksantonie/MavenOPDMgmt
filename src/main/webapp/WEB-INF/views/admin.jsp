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
<title>Insert title here</title>
	 <link rel="stylesheet" href="css/tab.css" media="screen" type="text/css" />
</head>
<body>
	<sf:form>
		<div class="tab">
		  <button class="tablinks" onclick="openCity(event, 'London')">London</button>
		  <button class="tablinks" onclick="openCity(event, 'Paris')">Paris</button>
		  <button class="tablinks" onclick="openCity(event, 'Tokyo')">Tokyo</button>
		</div>
	</sf:form>
</body>
</html>