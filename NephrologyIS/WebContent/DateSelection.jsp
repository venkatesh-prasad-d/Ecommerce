<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SelectDates</title>
 
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s"%>
	<s:form action="SearchOG">
		<s:set scope="session" name="patientId" value="dateBean.patientid"/>
		<s:submit></s:submit>
	</s:form>
	<s:form action="SearchAction">
	<s:text name="%{dateBean.patientid}"></s:text>
	<s:hidden value="%{dateBean.patientid}" name="searchbean.patientId"></s:hidden>
	<s:set scope="session" name="patientId" value="dateBean.patientid"/>
	<s:select list="dateList" listKey="dateList1" listValue="dateList1" name="searchbean.date"></s:select>
	
	<s:submit/>
	</s:form>
</body>
</html>