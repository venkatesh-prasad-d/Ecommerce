<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
     <%@ taglib uri="/struts-tags" prefix="s" %>
	<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome!!!!!!!!!!!</title>
	<sb:head/>
</head>
<body>
	<div class="container" style="border:2px solid #cecece;" cols="30">
		<div class="panel panel-primary">
 		<div class="panel-body">
 			<s:if test="hasActionMessages()">
				<div class="alert alert-success">
				<s:actionmessage/>
				</div>
			</s:if>
			<s:form action="addReport" theme="bootstrap" >
				<p>Add Report for the Week  <s:submit value="Add Report" cssClass="btn"></s:submit></p> 
			</s:form>
			<s:form action="viewReportDates" theme="bootstrap" cssClass="form-vertical">
				<s:hidden name="dateBean.emp_id" value="%{#session.username}" ></s:hidden>
				<p>View Reports <s:submit type="button" cssClass="btn btn-primary" value="View Report" ></s:submit></p> 
			</s:form>
		</div>
		</div>
	</div>
</body>
</html>