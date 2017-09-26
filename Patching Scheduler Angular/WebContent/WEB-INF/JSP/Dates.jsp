<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.8.18/themes/smoothness/jquery-ui.css"/>

<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script src="https://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Black Dates</title>
<style type="text/css">
	body{
  		padding-top: 80px;  		
  		padding-bottom: 50px;
  	}
</style>
<script type="text/javascript">
		
		 $(function () {
             $(".datepicker").datepicker();
         });
	</script>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
 <div class="container-fluid" style="background-color : lightblue   ">
  
     <h1><img  src=" <c:url value="/img/Lowes.png"/>" width="80" height="40" border="0" />Patching Scheduler</h1>

 </div>
 </div>
 	<div class="container">		
		<div class="form-group">
 
	<form:form action="dateForm" method="post" modelAttribute="b_dates" class="well form-vertical">
				<label>Select Black Dates : <input id="black_dates"  class="datepicker form-control"  onchange="getDates()"/></label>
				
				<br><label> list of Selected Dates : <form:textarea rows="10" cols="97" path="black_dates" id="final_dates" class="form-control" /></label>
				<br><input type="submit" value="Submit" class="btn btn-primary">
			</form:form>
		</div>
	</div>	
			
			<div class="footer navbar-fixed-bottom text-center">
	     
	     <div class="container-fluid" style="background-color : 	lightblue   ">
	       <h6>Identity And Access Management</h6>
	     </div>
	   </div>
	<script type="text/javascript">
		function getDates(){
			var in_date = document.getElementById("black_dates").value;
			var out_date = document.getElementById("final_dates");
			 out_date.innerHTML +=in_date+",";
		}
		</script>
		
</body>
</html>