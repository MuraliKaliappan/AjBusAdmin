<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
		
		<title>
			Bus Trip Selection  
		</title>		
		
	</head>
	
	
	<body>
	
		<div class="container-fluid">
			
			<br> <br> <br> <br> <br> <br> <br>
			<div class="row">
			
				<div class="col-md-offset-3 col-md-5"> 
				
					<form class="form-default" role="form" action="submitBusTripSelection" method="post" modelAttribute="busTripEntity">
			
						<div class="panel panel-info">
									
							<fieldset>	
								
								<div class="panel-heading "> <legend align="center"> <strong> Bus Trip Selection </strong> </legend> </div>
								
								<div class="panel-body">
									
									<div class="row form-group">
										<div class="col-md-6"> <input type="hidden" class="form-control" name="studentMail" value="${studentMail}" /> </div>
									</div>
									
									
									<div class="row form-group">
										<label class="control-label col-md-offset-1 col-md-3" for="area"> Area : </label> 
										<div class="col-md-6"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-map-marker"> </i> </span>
												<select class="form-control" name="area" ${empty busTripEntity ? '' : 'disabled'}> 
													<option disabled> Select Area </option>
													<option ${busTripEntity.area == 'Rajapalayam' ? 'selected' :''} > Rajapalayam </option>
													<option ${busTripEntity.area == 'Srivilliputur' ? 'selected' :''}> Srivilliputur </option>
													<option ${busTripEntity.area == 'Sivakasi' ? 'selected' :''}> Sivakasi </option>
												</select> 
											</div>
										</div>
									</div>
							
									<div class="row form-group">
										<label class="control-label col-md-offset-1 col-md-3" for="trip"> Trip : </label> 
										<div class="col-md-6"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-transfer"> </i> </span>
												<select class="form-control" name="trip" ${empty busTripEntity ? '' : 'disabled'}> 
													<option disabled> Select Trip </option>
													<option ${busTripEntity.trip == 'I Trip' ? 'selected' :''}> I Trip </option>
													<option ${busTripEntity.trip == 'II Trip' ? 'selected' :''}> II Trip </option>
												</select> 
											</div>
										</div>
									</div>
	
								</div>
								
							</fieldset>
							
							<div class="row form-group">
								<div class="col-md-offset-8">
									<button type="submit" class="btn btn-success" ${empty busTripEntity ? '' : 'disabled'}> Proceed </button> 
									<button type="button" class="btn btn-danger"> Cancel </button> 
								</div>
							</div>
							
						</div>
						
					</form>
				
				</div>
			
			</div>
					
		</div>
		
	</body>
	
</html>