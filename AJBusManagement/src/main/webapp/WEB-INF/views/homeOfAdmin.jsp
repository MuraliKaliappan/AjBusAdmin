<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Dashboard</title>

<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">

		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.min.css">

<script src="resources\jquery-3.3.1\jquery.js"></script>

<script src="resources\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

<!-- Alertify Java script included -->
<script src="resources\alertifyjs\alertify.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="resources\alertifyjs\css\alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="resources\alertifyjs\css\themes\default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="resources\alertifyjs\css\themes\semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="resources\alertifyjs\css\themes\bootstrap.min.css"/>

	<script type="text/javascript">
		$(document).ready(function(){
			
			var result 		= "${result}";
			var alertHeader = "${alertHeader}" 
			if(result != "") {
				alertify.alert(alertHeader, result, function(){
					window.location.href = '/AJBusManagement/admin/login';
				});		
			}
			
			
			var adminName = "${adminName}";
			if(adminName != "") {
				sessionStorage.setItem("user",adminName);
			} else {
				if(sessionStorage.getItem("user") == null){						
					window.location.href = '/AJBusManagement/'
				}	
				if(sessionStorage.getItem("user") != "admin"){						
					window.location.href = '/AJBusManagement/'
				} 
			}
			
			
			var userName = sessionStorage.getItem("user");
				$("h2").text(userName);
			
			$(".nav a[href='#tripManagement']").click(function() {
				$('#tripManagement').load('showTripManagement');
			})
			
			$(".nav a[href='#routeCost']").click(function() {
				$('#routeCost').load('showRouteCost');
			})
			
			
			$(".nav a[href='#paymentDetails']").click(function() {
				$('#paymentDetails').load('showPaymentDetails');
			})
			
			
			$(".nav a[href='#passwordChange']").click(function() {
				$('#passwordChange').load('showPasswordChange?userName='+sessionStorage.getItem("user"));
			})
			
			$(".nav a[href='#logout']").click(function() {	
				sessionStorage.removeItem("user");
				window.location.href="/AJBusManagement/"
			})
			
	
			
		})
			</script>

</head>

<body>
	<div class="page-header"> <center> <h3> <strong> Admin's Dashboard </strong></h3></center></div>
	
	<div class="container-fluid">


		<ul class="nav nav-tabs ">

			  <li class="active"> <a data-toggle="tab" href="#profile"> <i class="glyphicon glyphicon-user">  </i> </a></li>
  
			
				<li><a data-toggle="tab" href="#routeCost"> Route Cost </a></li>
		

			<li ><a data-toggle="tab" href="#tripManagement">	Trip Management </a></li>
			
			
			

			<li><a data-toggle="tab" href=#paymentDetails> Bus Fee Management </a>
			</li>

			<!-- <li><a data-toggle="tab" href="#adminMenu4"> Admin menu 4 </a>
			</li> -->
 
			<li><a data-toggle="tab" href="#passwordChange"> Change	Password </a></li>

			<li class="navbar-right" title="logout"><a data-toggle="tab" href="#logout"> <i class="glyphicon glyphicon-off"> </i>
			</a></li>

		</ul>





		<div class="tab-content">
			
			 <div id="profile" class="tab-pane fade in active"> 	<br> <br> <br>
				 <h1> Hello </h1> <h2> <script type="text/javascript"> document.write(userName); </script>  </h2>  <br>
					 <h3> 				<center>	>----			Welcome to your Dashboard			----> </center></h3> 	
			</div>

 
			


			<div id="tripManagement"  class="tab-pane fade ">

							</div>

			<div id="routeCost" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/tripSelection.jsp"></jsp:include> --%>
			</div>
			

			 <div id="paymentDetails" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/update.jsp"></jsp:include>  --%>
			</div>

			<%-- <div id="adminMenu4" class="tab-pane fade">
				<jsp:include page="/WEB-INF/views/challan.jsp"></jsp:include> 
			</div>  --%>

			<div id="passwordChange" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/passwordChange.jsp"></jsp:include> --%>
			</div>



			<div id="logout" class="tab-pane fade">logout</div>

		</div>
	</div>
</body>
</html>