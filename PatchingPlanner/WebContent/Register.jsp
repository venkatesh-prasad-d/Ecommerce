<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register!!!!!!!</title>
</head>
<body>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:form action="newuser" method="post">
 <s:textfield label="Enter your sales ID" key="registerbean.uid"></s:textfield><br>
<s:textfield label = "Enter your name" key="registerbean.name"></s:textfield><br>

<s:password label="Enter New Password" key="registerbean.pass"></s:password><br>
<s:password label="Confirm Password" key="registerbean.cpass"></s:password>
<s:submit></s:submit>
</s:form>

</body>
</html>