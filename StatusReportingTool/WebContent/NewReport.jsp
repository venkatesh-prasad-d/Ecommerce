<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-bootstrap-tags" prefix="sb" %>
    <%@ taglib uri="/struts-tags" prefix="s" %>
	<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
	<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Report</title>
	<sb:head/>
	<sx:head/>
</head>
<body>
	<div class="container" style="border:2px solid #cecece;"  >
		<div class="panel-primary">
 		<div class="panel-body">
			<s:form action="newReport" method="post" theme="bootstrap">
 				<s:textfield label="Employee ID" value="%{#session.username}" key="reportbean.emp_id"  disabled="true"></s:textfield>
 				<s:hidden name="reportbean.emp_id" value="%{#session.username}" ></s:hidden>
 				<s:textfield label="Employee Name" value="%{#session.name}" key="reportbean.emp_name" disabled="true"></s:textfield>
 				<s:hidden name="reportbean.emp_name" value="%{#session.name}" ></s:hidden>
 				<s:if test="fieldErrors.containsKey('startDate')">
 				<div class="alert alert-danger">
 					<s:fielderror fieldName="startDate"></s:fielderror>
 				</div>
 				</s:if>
 				<sx:datetimepicker name="startdate" label="Enter Start Date" displayFormat="yyyy-MM-dd"></sx:datetimepicker>
				<s:if test="fieldErrors.containsKey('endDate')">
					<div class="alert alert-danger">
 						<s:fielderror fieldName="endDate"></s:fielderror>
 					</div>
 				</s:if>
				<sx:datetimepicker name="enddate" label="Enter End Date" displayFormat="yyyy-MM-dd"></sx:datetimepicker> 
 				<s:if test="fieldErrors.containsKey('taskCompleted')">
	 				<div class="alert alert-danger">
	 					<s:fielderror fieldName="taskCompleted"></s:fielderror>
	 				</div>
 				</s:if>
 				<s:textarea label="Target Accomplised" key="reportbean.taskCompleted" rows="6"></s:textarea>
 				<s:if test="fieldErrors.containsKey('taskNW')">
	 				<div class="alert alert-danger">
	 					<s:fielderror fieldName="taskNW"></s:fielderror>
	 				</div>
 				</s:if>
				<s:textarea label="Targets for Next Week" key="reportbean.taskNW" rows="6"></s:textarea>
				<s:textarea label="Issues" key="reportbean.issues" rows="6"></s:textarea>
 				<s:submit cssClass="btn btn-primary" ></s:submit>
 			</s:form>
 		</div>
 		</div>
	 </div> 	
</body>
</html>