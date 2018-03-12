<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.pckg.opd.dao.MedicineDao"%>
<%@ page import="com.pckg.opd.hibernate.Medicine"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form commandName="medicine" action="showmedicine">
<input type="submit" value="Show medicines"/>
	<table border="2" width="70%" cellpadding="2">  
<tr><th>Medicine</th><th>No: of strips</th><th>Price per strip</th></tr>
<%--  <c:forEach var="medicine" items="${medicine}"> --%>
<tr>
<td>sdasdad</td>
</tr>
</table>
</sf:form>


</body>
</html>