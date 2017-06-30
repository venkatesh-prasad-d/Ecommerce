<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
 <%@ taglib uri="/struts-tags" prefix ="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Status Reporting Tool</title>
	<sb:head/>
</head>
<body>
	<div class="container" style="border:5px solid #cecece;"  >
	<div class="page-header"  >
	<div class="panel panel-info">
 	<div class="panel-body">
		<b>STATUS REPORTING TOOL</b>
	</div>
	</div>
	</div>
	</div>
	<div class="pane panel-primary">
		<div class="panel-body">
		<div class="container" style="border:5px solid #cecece;"  >
		<s:if test="hasActionErrors()">
			<div class="alert alert-danger ">
			<s:actionerror/>
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="alert alert-success">
			<s:actionmessage/>
			</div>
		</s:if>
		<s:form action="login" method="post" theme="bootstrap" cssClass="well form-vertical">
			<s:textfield label="Enter User Name" key="loginbean.uname"></s:textfield><br>
			<s:password label="Enter Password" key="loginbean.pass"></s:password><br>
			<s:submit value="Login" cssClass="btn btn-primary pull-middle"></s:submit>
			<s:submit action="register" value="Sign-Up" cssClass="btn btn-primary"></s:submit>
		</s:form>
		</div>
	</div>
	</div>
</body>
</html>