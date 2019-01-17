<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
<link rel="stylesheet"
	href="resources\bootstrap-3.3.7-dist\css\bootstrap.min.css">

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

<title>Home Page</title>


<script type="text/javascript">
	$(document).ready(function() {

		var result = "${result}";
		
		if(result != "") {
			alertify.alert("Error..!", result, function(){
				window.location.href = '/AJBusManagement/';
			});		
		}
		
		if(sessionStorage.getItem("user") != null) {
			window.location.href = '/AJBusManagement/student/login'
		}
		
		
		
		
		
		$(".nav-tabs a[href='#registration']").click(function() {	
			$('#registration').load('showRegistration');
		})

		$(".nav a[href='#studentLogin']").click(function() {
			$('#studentLogin').load('showStudentLogin');
		})

		$(".nav a[href='#adminLogin']").click(function() {
			$('#adminLogin').load('showAdminLogin');
		})

		
		
		
		
	})
</script>
</head>


<body>

	<div class="page-header">
		<center>
			<h3>
				<strong> Online College Bus Management </strong>
			</h3>
		</center>
	</div>


	<div class="container-fluid">

		<label class=label>${result}</label>
		<ul class="nav nav-tabs navbar-right">

			<li><a data-toggle="tab" href="#registration"> Registration
			</a></li>

			<li><a data-toggle="tab" href="#studentLogin"> Student's
					Login </a></li>

			<li><a data-toggle="tab" href="#adminLogin"> Admin's Login </a></li>

		</ul>





		<div class="tab-content">

			<div id="registration" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/registration.jsp"></jsp:include> --%>
			</div>

			<div id="studentLogin" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/studentLogin.jsp"></jsp:include> --%>
			</div>

			<div id="adminLogin" class="tab-pane fade">
				<%-- <jsp:include page="/WEB-INF/views/adminLogin.jsp"></jsp:include>  --%>
			</div>

		</div>



	</div>

	<!-- <script>
			
			$(document).ready(function(){
			
				alert $(result);
			});
			
		</script> -->



</body>

</html>
