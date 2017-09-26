<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

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
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        
<title>Schedule Servers</title>

<style type="text/css">
	body{
  		padding-top: 80px;  		
  		padding-bottom: 50px;
  	}
</style>
</head>
<body ng-app="Ang" ng-controller="scheduleController">
<div class="navbar navbar-default navbar-fixed-top">
 <div class="container-fluid" style="background-color : lightblue   ">
  
     <h1>Patching Scheduler</h1>

 </div>
 </div>
 
	<div class="container">		
		<div class="form-group">
			<div align="right">
				<a href="dateForm">Update Black Dates For the Year</a>
			</div>
			
				<form ng-submit="submitSchedule()" class="well form-vertical">
			
					<label>Start Date : <input type="text" class="datepicker form-control" ng-model="scheduleForm.startDate" ></label>
					<br><label>End Date : <input type="text" class="datepicker form-control" ng-model="scheduleForm.endDate"></label>
					<br><label>Servers : <textarea class="form-control" ng-model="scheduleForm.servers" rows="20" cols="17"></textarea> </label>
				<br><input type="submit" value="submit">
				</form>
			
			
			<table class="table table-bordered" style="width:100%">
		<thead>
			<tr class="success">
				<th>Name</th>
				<th>IP Address</th>
				<th>Type</th>
				<th>Environment</th>
				<th>Category</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="list in scheduler">
				<td>{{list.name}}</td>
						<td>{{list.ip_address}}</td>
						<td>{{list.type}}</td>
						<td>{{list.environment}}</td>
						<td>{{list.category}}</td>
						<td>{{list.date}}</td>
			</tr>							
		</tbody>
		
	</table>
			
		</div>
	</div>	
	   <div class="footer navbar-fixed-bottom text-center">
	     
	     <div class="container-fluid" style="background-color : 	lightblue   ">
	       <h6>Identity And Access Management</h6>
	     </div>
	   </div>

      
</body>
     <script type="text/javascript">            
     var app = angular.module("Ang",[]);
     app.controller("scheduleController",function($scope,$http){
     	
     	$scope.submitSchedule= function() {
     		
     		$http({
     			method : "POST",
     			url : "Rest/scheduleServer",
     			data : angular.toJson($scope.scheduleForm),
     			headers : {
     				'Accept':'application/json',
     				'Content-Type' : 'application/json'
     			}
     		
     		}).then(function(response){
     			
     			$scope.scheduler = response.data;
     		})
     	}
     });
     $(function () {
         $(".datepicker").datepicker();
     });
    	
        </script>
</html>