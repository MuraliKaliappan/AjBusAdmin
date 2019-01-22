<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
		
		<title>
			Update Form
		</title>
		
		<script type="text/javascript">
			function cancel()
			{
				window.location.href = '/AJBusManagement/student/login';	
			}
		</script>
		
	</head>
	
	
	<body>
	
		<div class="container-fluid">
		
			<h3>  <strong> Update the Student's Details </strong> </h3>
			
			<div class="row">
			
				<div class="col-md-offset-1 col-md-9"> 
				
					<form class="form-default" role="form" action="submitUpdate" method="post">
			
						<div class="page-header" >	
						
							<div class="row form-group">
								<div class="col-md-3"> <input type="hidden" class="form-control" name="emailId" value="${studentEntity.emailId}" /> </div>
							</div>
								
						
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="name"> Name : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-user"> </i> </span>
										<input type="text" placeholder="FULLNAME" class="form-control" name="name" value="${studentEntity.studentName }"> 
										
									</div>						
								</div>							 
							</div>
							
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="name"> Email Id : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-user"> </i> </span>
										<input type="text" class="form-control" name="emailId" value="${studentEntity.emailId}" disabled> 
										
									</div>						
								</div>							 
							</div>	
												
							<%-- <div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="dob"> Date Of Birth : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-calendar"> </i> </span>
										<input type="date"  class="form-control" name="dob" value="${studentEntity.dateOfBirth}"> 
										
									</div>
								</div>
							</div> --%>
						
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="degree"> Degree : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-education"> </i> </span>
										<select class="form-control" name="degree"> 
											<option disabled> Select Degree </option>
											<option ${studentEntity.degree == 'UG' ? 'selected' :''}> UG</option>
											<option ${studentEntity.degree == 'PG' ? 'selected' :''}> PG</option>
											<option${studentEntity.degree == 'M.Phil' ? 'selected' :''}> M.Phil</option>
											<option${studentEntity.degree == 'Diploma' ? 'selected' :''}> Diploma</option>
										</select> 
										
									</div>
								</div>
							</div>

							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="yearOfStudying"> Year of Studying : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-bookmark"> </i> </span>
										 <select class="form-control" name="yearOfStudying"> 
											<option disabled> Select the Studying year </option>
											<option ${studentEntity.studyingYear =='I Year' ? 'selected' :''}> I Year</option>
											<option ${studentEntity.studyingYear =='II Year' ? 'selected' :''}> II Year</option>
											<option ${studentEntity.studyingYear =='III Year' ? 'selected' :''}> III Year</option>
										</select> 
										
										
									</div>
								</div>		
							</div>
							
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="mob"> Contact Number : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-earphone"> </i> </span>
										<input type="number" value="${studentEntity.mobileNumber}" class="form-control" name="mob" max="9999999999" placeholder="Mobile Number" > 
										
									</div>
								</div>
							</div>	
							
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="emergency"> Emergency Contact : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-phone"> </i> </span>
										<input type="number" placeholder="Emergency Number" class="form-control" name="emergency" max="9999999999" value="${studentEntity.emergencyNumber}"> 
										
									</div>
								</div>
							</div>	

							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="bloodGroup"> Blood Group : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-tint"> </i> </span>
										<select class="form-control" name="bloodGroup">											
											<option disabled> Select Blood Group </option>
											<option ${studentEntity.bloodGroup == 'A+' ? 'selected' : ''}> A+ </option>
											<option ${studentEntity.bloodGroup == 'B+' ? 'selected' : ''}> B+ </option>
											<option ${studentEntity.bloodGroup == 'AB+' ? 'selected' : ''}> AB+ </option>
											<option ${studentEntity.bloodGroup == 'O+' ? 'selected' : ''}> O+ </option>
											<option ${studentEntity.bloodGroup == 'A-' ? 'selected' : ''}> A- </option>
											<option ${studentEntity.bloodGroup == 'B-' ? 'selected' : ''}> B- </option>
											<option ${studentEntity.bloodGroup == 'AB-' ? 'selected' : ''}> AB- </option>
											<option ${studentEntity.bloodGroup == '0-' ? 'selected' : ''}> O- </option>
										</select>
										
									</div>
								</div>
							</div>
							
						</div>
						
						<div class="row form-group">
							<div class="col-md-offset-9">
								<button type="submit" class="btn btn-success"> Update </button> 
								<button type="button" class="btn btn-danger" onClick="cancel()"> Cancel </button> 
							</div>
						</div>
						
					</form>
				
				</div>
			
			</div>
					
		</div>
		
	</body>
	
</html>