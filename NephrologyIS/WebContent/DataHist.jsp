<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historical Data</title>
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<table>
		<tr>
			<th>Patient ID</th>
			<th>Machine ID</th>
			<th>T1</th>
			<th>T2</th>
			<th>T3</th>
			<th>T4</th>
			<th>T5</th>
			<th>bflow</th>
			<th>arterialpressure</th>
			<th>bolus</th>
			<th>status</th>
			<th>Date</th>
		</tr>
		<s:iterator value="searchlist">

		<tr>
			<td>	<s:property value="patientId"/> </td>
			<td>	<s:property value="machineId"/> </td>
			<td>	<s:property value="T1"/> </td>
			<td>	<s:property value="T2"/> </td>
			<td>	<s:property value="T3"/> </td>
			<td>	<s:property value="T4"/>
			<td>	<s:property value="T5"/>
			<td>	<s:property value="bflow"/>
			<td>	<s:property value="arterialpressure"/>
			<td>	<s:property value="bolus"/>
			<td>	<s:property value="status"/>
			<td>	<s:property value="sqlDate"/>
		</tr>

		</s:iterator>
	</table>


</body>
</html>