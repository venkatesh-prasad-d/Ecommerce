<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patching Planner</title>
</head>
<body>
<%@ taglib uri="/struts-tags" prefix ="s" %>
<s:form action="login" method="post">
<s:textfield label="Enter User Name" key="loginbean.uname"></s:textfield><br>
<s:password label="Enter Password" key="loginbean.pass"></s:password><br>
<s:submit label="Submit"></s:submit>
</s:form>
<s:form action="register" method="post">
<s:submit label="Register"></s:submit>
</s:form>
</body>
</html>