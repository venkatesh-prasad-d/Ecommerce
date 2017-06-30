<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="addRelease">
<s:textfield name="releaseBean.releaseID"></s:textfield>
<table class="table table-bordered">

<s:iterator value="fixesList"  >
	<tr>		
	<td><s:checkbox fieldValue="%{fnfId}" name="fnfId" label="%{fnfId}"></s:checkbox></td>
	<td><s:property value="item"/>
	<td><s:property value="note"/></td>
	<td><s:property value="status"/></td>
	</tr>
</s:iterator>
</table>
<s:submit></s:submit>
</s:form>
</body>
</html>