<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="/struts-tags" prefix="s" %>
	<s:form action="select">
		<s:select label = "Select The Category of Servers"
			headerKey="-1" headerValue="Select Category" 
			list="#{'ALL':'ALL','ILM':'ILM','SITEMINDER':'SITEMEINDER','VENDOR PORTAL':'VENDOR PORTAL' }"
			name="sb.category"
			value="ALL">
		</s:select>
		<s:submit></s:submit>
	</s:form>
	
	<s:form action="search">
		<s:textarea></s:textarea>
	</s:form>

</body>
</html>