<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PatientList</title>
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<s:form action="dateAction">
	
	</s:form>
	<s:form action="dateAction">
		<s:select key="Select Patient" list="patientlist" listKey="patientId" listValue="patientId" name="dateBean.patientid"></s:select>
		<s:submit/>
	</s:form>
</body>
</html>