<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Login</title>
</head>
<body>
<%@ taglib uri="/struts-tags" prefix="s" %>
	<s:form action="login" method="post">
		<s:textfield key="loginbean.userName" label="Enter The User Name"></s:textfield>
		<s:password key="loginbean.password" label="Enter the password"></s:password>
		<s:submit value="login"></s:submit>
 	</s:form>
 	<s:form action="newRegistration">
 		<s:submit value="Register"></s:submit>
 	</s:form>

</body>
</html>