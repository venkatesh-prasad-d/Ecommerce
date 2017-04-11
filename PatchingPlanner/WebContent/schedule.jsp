<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Patching</title>
</head>
<body>

<s:form action="schedule" method="post">
<s:textarea label="Enter the servers to be patched" name="patchlist" cols="16" rows="17"></s:textarea>
<sx:datetimepicker name="startdate" label="Enter Start Date" displayFormat="dd-MMM-yyyy"></sx:datetimepicker>
<sx:datetimepicker name="enddate" label="Enter End Date" displayFormat="dd-MM-yyyy"></sx:datetimepicker>
<s:submit></s:submit>

</s:form>

</body>
</html>