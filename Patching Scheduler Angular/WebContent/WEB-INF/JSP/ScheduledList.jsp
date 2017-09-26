<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Server Schedule</title>
<style type="text/css">
	body{
  		padding-top: 80px;  		
  		padding-bottom: 50px;
  	}
</style>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
 <div class="container-fluid" style="background-color : lightblue">
  
     <h1><img  src="img/Lowes.png" width="80" height="40" border="0" />Patching Scheduler</h1>

 </div>
 </div>
 <div class="table-responsive">
 <div class="pull right">
 <a href="#" onclick="fnExcelReport()"><span class="glyphicon glyphicon-download-alt">Export</span></a>
	</div>
	
	<table class="table table-bordered" style="width:100%" id = "myTable">
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
			<c:forEach var="model" items="${modelList}" >
				<c:forEach var="list" items="${model}">
					<tr class="small" class="info">
						<td>${list.name}</td>
						<td>${list.ip_address}</td>
						<td>${list.type}</td>
						<td>${list.environment}</td>
						<td>${list.category}</td>
						<td>${list.date}</td>
						
					</tr>
				</c:forEach>
			</c:forEach>					
		</tbody>
		
	</table>

  </div>
   <div class="footer navbar-fixed-bottom text-center">
	     
	     <div class="container-fluid" style="background-color : lightblue">
	       <h6>Identity And Access Management</h6>
	     </div>
	   </div>
	   <script type="text/javascript">

	   function fnExcelReport()
	   {
	       var tab_text = '<table border="1px" style="font-size:20px" ">';
	       var textRange; 
	       var j = 0;
	       var tab = document.getElementById('myTable'); // id of table
	       var lines = tab.rows.length;

	       // the first headline of the table
	       if (lines > 0) {
	           tab_text = tab_text + '<tr bgcolor="#DFDFDF">' + tab.rows[0].innerHTML + '</tr>';
	       }

	       // table data lines, loop starting from 1
	       for (j = 1 ; j < lines; j++) {     
	           tab_text = tab_text + "<tr>" + tab.rows[j].innerHTML + "</tr>";
	       }

	       tab_text = tab_text + "</table>";
	       tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, "");             //remove if u want links in your table
	       tab_text = tab_text.replace(/<img[^>]*>/gi,"");                 // remove if u want images in your table
	       tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, "");    // reomves input params
	       // console.log(tab_text); // aktivate so see the result (press F12 in browser)*/

	       var ua = window.navigator.userAgent;
	       var msie = ua.indexOf("MSIE "); 

	        // if Internet Explorer
	       if (msie > 0 ) {
	           txtArea1.document.open("txt/html","replace");
	           txtArea1.document.write(tab_text);
	           txtArea1.document.close();
	           txtArea1.focus(); 
	           sa = txtArea1.document.execCommand("SaveAs", true, "DataTableExport.xlsx");
	       }  
	       else // other browser not tested on IE 11
	       	
	       
	           sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

	       return (sa);
	   }  


	   </script>
</body>
</html>