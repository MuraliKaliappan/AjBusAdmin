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
		
	</head>
	
	
	<body>
	
		<div class="container-fluid">
		
			<h3>  <strong> Update the Student's Details </strong> </h3>
			
			<div class="row">
			
				<div class="col-md-offset-1 col-md-9"> 
				
					<form class="form-default" role="form">
			
						<div class="page-header" >	
						
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="name"> Name : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-user"> </i> </span>
										<input type="text" value="FULLNAME" class="form-control" name="name" > 
										
									</div>						
								</div>							 
							</div>	
												
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="dob"> Date Of Birth : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-calendar"> </i> </span>
										<input type="date" value="" class="form-control" name="dob"> 
										
									</div>
								</div>
							</div>
						
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="degree"> Degree : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-education"> </i> </span>
										<select class="form-control" name="degree"> 
											<option disabled> Select Degree </option>
											<option> UG</option>
											<option> PG</option>
											<option> M.Phil</option>
											<option> Diploma</option>
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
											<option> I Year</option>
											<option> II Year</option>
											<option> III Year</option>
										</select> 
										
										
									</div>
								</div>		
							</div>
							
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="mob"> Contact Number : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-earphone"> </i> </span>
										<input type="number" value="" class="form-control" name="mob" max="9999999999" placeholder="Mobile Number"> 
										
									</div>
								</div>
							</div>	
							
							<div class="row form-group">
								<div class="col-md-3"> <label class="control-label" for="emergency"> Emergency Contact : </label> </div>
								<div class="col-md-8"> 
									<div class="input-group">
										<span class="input-group-addon"> <i class="glyphicon glyphicon-phone"> </i> </span>
										<input type="number" placeholder="Emergency Number" class="form-control" name="emergency" max="9999999999"> 
										
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
											<option> A+ </option>
											<option> B+ </option>
											<option> AB+ </option>
											<option> O+ </option>
											<option> A- </option>
											<option> B- </option>
											<option> AB- </option>
											<option> O- </option>
										</select>
										
									</div>
								</div>
							</div>
							
						</div>
						
						<div class="row form-group">
							<div class="col-md-offset-9">
								<button type="submit" class="btn btn-success"> Update </button> 
								<button type="button" class="btn btn-danger"> Cancel </button> 
							</div>
						</div>
						
					</form>
				
				</div>
			
			</div>
					
		</div>
		
	</body>
	
</html>