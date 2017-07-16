<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<div class="container" style="border:4px solid #cecece;"  >
	<div class="page-header" class="container" >
	<div class="panel-primary">
 	<div class="panel-body">
		<b>NIS</b>
		<s:if test="#session.username == null" >
		<%
			response.sendRedirect("Login.jsp");
		%>
		</s:if>
		<div class="pull-right" >
		<b>Welcome :</b> <s:text  name="%{#session.name} "  />		
			<a href="patient" >Home</a>
			<a href="logout">Logout</a>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>