<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
      <%@include file="header.jsp" %>
      <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Selected Report</title>
	<sb:head/>
</head>
<body>
	<div class="container" style="border:2px solid #cecece;"  >
		<div class="panel-primary">
 		<div class="panel-body">		
		<div theme="bootstrap" class="well form-vertical">
			<br> <s:textarea value="%{viewBean.week}"  label="Report for the Week" disabled="true" />			
			<br><s:textarea label=" Uploaded  Result" value="%{viewBean.fileData}" cols="200" rows="15" disabled="true"/>
		</div>				
		</div>
		</div>
	</div>	
</body>
</html>