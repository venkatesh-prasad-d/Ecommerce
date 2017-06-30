<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
      <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SelectDates</title>
	<sb:head/>
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s"%>
	<div class="container" style="border:2px solid #cecece;"  >
	<div class="panel-primary">
 	<div class="panel-body">
	<s:form action="ViewReport">
		<s:hidden name="viewBean.emp_id" value="%{#session.username}"></s:hidden>
		<s:select list="dateList" listKey="startDate" listValue="dates" name="viewBean.startDate" label="Select Week"></s:select>
		<s:submit value="View Report" cssClass="btn btn-primary"/>
	</s:form>
	</div>
	</div>
	</div>
</body>
</html>