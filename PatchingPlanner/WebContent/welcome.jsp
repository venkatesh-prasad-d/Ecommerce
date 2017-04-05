<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="ilm_server">
	<p>List ILM Servers <s:submit value="Show servers" ></s:submit></p> 
</s:form>

<s:form action="sm_server">
	<p>List SiteMinder Servers <s:submit value="Show servers" ></s:submit></p> 
</s:form>

<s:form action="vp_server">
	<p>List Vendor Portal Servers <s:submit value="Show servers" ></s:submit></p> 
</s:form>

<s:form action="server">
	<p>List Servers <s:submit value="Show servers" ></s:submit></p> 
</s:form>

</body>
</html>