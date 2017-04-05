<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<table>
		<tr>
			<th>Name</th>
			<th>IP address</th>
			<th>Type</th>
			<th>Environment</th>
			<th>Category</th>
		</tr>
		<s:iterator value="arraBean">

		<tr>
			<td>	<s:property value="name"/> </td>
			<td>	<s:property value="ip_address"/> </td>
			<td>	<s:property value="type"/> </td>
			<td>	<s:property value="environment"/> </td>
			<td>	<s:property value="category"/> </td>
		</tr>

		</s:iterator>
	</table>

</body>
</html>