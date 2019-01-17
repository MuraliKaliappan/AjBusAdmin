<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="resources\bootstrap-3.3.7-dist\css\bootstrap.css">
		
		<title>
			Login Form for Student
		</title>
		
	</head>
	
	
	<body>
	
		<div class="container">
			
			<form class="form-inline" role="form" action="student/login" method="post">
				
				<div class="form-group">
							 
					<div class="container">
									
						<div class="rows">
							
							
							<div class="panel-group ">
								
								<div class="row"> <div class="col-md-offset-3 col-md-5"> 
									<div class="panel panel-primary">
									
									<div class="panel-heading "> <div class="row"> <div class="col-md-offset-4 col-md-8">Student's Login </div>  </div> </div>									
									
						
									<div class="panel-body">
										<br> <br> <br>
										
										<div class="row">
											<div class="col-md-offset-3"> 
												<div class="input-group"> 
													<span class="input-group-addon"><i class="glyphicon glyphicon-user"> </i></span>
													<input type="email" placeholder="Username or E-Mail ID" class="form-control" name="studentEmailId" required> 
												</div>
											</div>
										</div>
										
										<br>
										
										
										<div class="row">
											<div class="col-md-offset-3"> 
												<div class="input-group">
													<span class="input-group-addon"> <i class="glyphicon glyphicon-lock"> </i> </span> 
													<input type="password" class="form-control" name="studentPassword" placeholder="Password" required> 
												</div>
											</div>
										</div>
											
										<br> <br><br>
										
										<div class="row">
											<div class="col-md-offset-4"> <button type="submit" class="btn btn-success">Login</button> 
											<button type="button" class="btn btn-danger">Cancel </button> </div>
										</div>
									
									</div>
											
								</div> </div></div>
							
							</div>
							
						</div>
					</div>
					
				</div>
			</form>	
		
		</div>
	</body>
</html>