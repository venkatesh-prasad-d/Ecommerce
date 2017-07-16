<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <s:form action="newUser" method="post">
 	
 	<s:textfield key="registerbean.name" label="Enter Your Name"></s:textfield>
 	<s:textfield key="registerbean.username" label="Enter UserName"></s:textfield>
 	<s:password key="registerbean.password" label="Enter Password"></s:password>
 	<s:submit></s:submit>
 </s:form>
</body>
</html>