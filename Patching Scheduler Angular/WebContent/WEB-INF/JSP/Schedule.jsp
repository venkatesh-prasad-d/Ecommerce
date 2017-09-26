<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.8.18/themes/smoothness/jquery-ui.css"/>

<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script src="https://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
<title>Schedule Servers</title>

<style type="text/css">
	body{
  		padding-top: 80px;  		
  		padding-bottom: 50px;
  	}
</style>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
 <div class="container-fluid" style="background-color : lightblue   ">
  
     <h1><img  src=" <c:url value="/img/Lowes.png"/>" width="80" height="40" border="0" />Patching Scheduler</h1>

 </div>
 </div>
 
	<div class="container">		
		<div class="form-group">
			<div align="right">
				<a href="dateForm">Update Black Dates For the Year</a>
			</div>
			<form:form action="scheduleServer" method="post" modelAttribute="ServerList" class="well form-vertical">
				<label>Select Start Date : <form:input path="startDate" class="datepicker form-control" /></label>
				<br><label>Select End Date : <form:input path="endDate" class="datepicker form-control" /></label>
				<br><label>Enter the list of non-compliant servers : <form:textarea rows="20" cols="17" path="servers" class="form-control" /></label>
				<br><input type="submit" value="Submit" class="btn btn-primary">
			</form:form>
		</div>
	</div>	
	   <div class="footer navbar-fixed-bottom text-center">
	     
	     <div class="container-fluid" style="background-color : 	lightblue   ">
	       <h6>Identity And Access Management</h6>
	     </div>
	   </div>
     <script>
            $(function () {
                $(".datepicker").datepicker();
            });
        </script>
   
</body>
</html>