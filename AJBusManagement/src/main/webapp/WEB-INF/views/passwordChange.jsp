<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
		
		<title>
			Change Password  
		</title>
		
	</head>
	
	
	<body>
	
		<div class="container-fluid">
			
			<br> <br> <br> <br> <br> <br> <br>
			<div class="row">
			
				<div class="col-md-offset-3 col-md-5"> 
				
					<form class="form-default" role="form">
			
						<div class="panel panel-info">
									
							<fieldset>	
								
								<div class="panel-heading "> <legend align="center"> <strong> Change Password </strong> </legend> </div>
								
								<div class="panel-body">
								
									<div class="row form-group">
										<div class="col-md-4"> <label class="control-label" for="old"> Old Password : </label> </div>
										<div class="col-md-8"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-pencil"> </i> </span>
												<input type="password" class="form-control" name="old" placeholder="Old Password" required> 
										
											</div>
										</div>
									</div>
									
									<div class="row form-group">
										<div class="col-md-4"> <label class="control-label" for="newPwd"> New Password : </label> </div>
										<div class="col-md-8"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-lock"> </i> </span>
												<input type="password" class="form-control" name="newPwd" placeholder="New Password" required> 
										
											</div>
										</div>
									</div>

									<div class="row form-group">
										<div class="col-md-4"> <label class="control-label" for="confirm"> Confirm Password : </label> </div>
										<div class="col-md-8"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-link"> </i> </span>
												<input type="password" placeholder="Confirm Password" class="form-control" name="confirm" required> 
										
											</div>
										</div>
									</div>
							
								</div>
								
							</fieldset>
							
							<div class="row form-group">
								<div class="col-md-offset-8">
									<button type="submit" class="btn btn-success"> Change </button> 
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