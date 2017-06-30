<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
      <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register!!!!!!!</title>
	<sb:head/>
</head>
<body>
	<div class="container" style="border:5px solid #cecece;"  >
		<div class="page-header"  >
		<div class="panel panel-primary">
 		<div class="panel-body">
			<b>STATUS REPORTING TOOL</b>
		</div>
		</div>
		</div>
	</div>
	<div class="container" style="border:2px solid #cecece;"  >
		<s:if test="hasActionErrors()">
			<div class="alert alert-danger ">
				<s:actionerror/>
			</div>
		</s:if>
		<s:form action="newuser" method="post" theme="bootstrap" cssClass="well form-vertical">
 			<s:textfield label="Enter your sales ID" key="registerbean.uid"  ></s:textfield><br>
			<s:textfield label = "Enter your name" key="registerbean.name" ></s:textfield><br>
			<s:password label="Enter New Password" key="registerbean.pass" ></s:password><br>
			<s:password label="Confirm Password" key="registerbean.cpass" ></s:password>
			<s:submit Value="Register" cssClass="btn btn-primary"></s:submit>
		</s:form>
	</div>
</body>
</html>