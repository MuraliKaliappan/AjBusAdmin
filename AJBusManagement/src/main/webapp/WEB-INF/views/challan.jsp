<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
		<script src="resources\jquery-3.3.1\jquery.js"></script>
		<script src="resources\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
		<script src="resources\jspdf\jspdf.debug.js"></script>
		
		<title>
			Challan
		</title>
		
		
		<script>
			
			$(document).ready(function(){

				$("#btnPrint").click(function(){

					console.log("hai");

					var printContents = $("#printContainer").html();
				
					var printWindow = window.open('','','height=400,width=800');

					printWindow.document.write('<html><head><title> Bus Fee Challan </title>');

					printWindow.document.write('</head><body>');				

					printWindow.document.write(printContents);

					printWindow.document.write('</body></html>');

					printWindow.document.close();

					printWindow.print();
				});

			});
			
		</script>
		
		
	</head>
	
	
	<body>
		
		<div class="container-fluid" id="printContainer">
		<h3><strong> Payment Slip </strong>  </h3>
			
			<div class="row">
			
				<div class="col-md-offset-2 col-md-7"> 
				
					<form class="form-default" role="form">
			
						<div class="page-header">
						
							<fieldset>	
							
								<div class="row form-group "> 
									<div class="col-md-offset-5 col-md-5"> 
										<div class="input-group"> 
												<div class="input-group-addon"><label class="control-label" for="date"> Date : </label></div>
												<input type="text" value="" class="form-control" id="date" >
										</div>
									</div>
								</div>
																
								<div class="row form-group">
									<label class="control-label col-md-3" for="name"> Name : </label> 
									<div class="col-md-7"> <input type="text" value="${studentEntity.studentName}" class="form-control" id="name" disabled> </div>					
								</div>	
												
														
								<div class="row form-group">
									<label class="control-label col-md-3" for="degree"> Degree : </label> 
									<div class="col-md-7"> <input type="text" value="${studentEntity.degree}" class="form-control" id="degree" disabled> </div>
								</div>

								<div class="row form-group">
									<label class="control-label col-md-3" for="year"> Year of Studying :</label>
									<div class="col-md-7"> <input type="text" value="${studentEntity.studyingYear}" class="form-control" id="year" disabled> </div>
								</div>
							
								<div class="row form-group">
									<label class="control-label col-md-3" for="mail"> E-Mail ID : </label> 
									<div class="col-md-7"> <input type="email" value="${studentEntity.emailId}" class="form-control" id="mail" disabled> </div>
								</div>
							
								<div class="row form-group">
									<label class="control-label col-md-3" for="area"> Area : </label> 
									<div class="col-md-7"> <input type="text" value="${studentEntity.busTripEntity.area}" class="form-control" id="area" disabled> </div>
								</div>
								
								<div class="row form-group">
									<label class="control-label col-md-3" for="trip"> Trip : </label> 
									<div class="col-md-7"> <input type="text" value="${studentEntity.busTripEntity.trip}" class="form-control" id="trip" disabled> </div>
								</div>	
								
								<div class="row form-group">
									<label class="control-label col-md-3" for="trip"> Amount : </label> 
									<div class="col-md-7"> <input type="text" value="${studentEntity.busTripEntity.routeCostEntity.amount}" class="form-control" id="trip" disabled> </div>
								</div>	 																						
							
						
								<div class="row form-group">
									<label class="control-label col-md-3" for="status"> Status : </label> 
									<div class="col-md-7"> <input type="text" value="${ studentEntity.busTripEntity.finalStatus ? 'Accepted' :'Request Pending' }" class="form-control" id="status" disabled> </div>
								</div>
							
							</fieldset>
						</div>
						
						<div class="row form-group ">
							<span class="col-md-offset-9 btn glyphicon glyphicon-print btn-lg btn-info" data-toggle="tooltip" data-placement="auto" id="btnPrint" title="Print" ${ studentEntity.busTripEntity.finalStatus ? '' :'disabled' }></span> 
						</div>
						
					</form>
				
				</div>
			
			</div>
					
		</div>
		
		<!-- <div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="alert alert-warning alert-dismissable"> 
						<button type="button" class="close" data-dismiss="alert"> x </button>
						<strong> Closing Date for Fees Payment is : 14 / 01/ 2018  </strong> 
					</div>
				</div>
			</div>
		</div> -->
		
	</body>
	
</html>