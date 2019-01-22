<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin Route Cost</title>

		<script type="text/javascript">
			function cancel()
			{
				window.location.href = '/AJBusManagement/admin/login';	
			}
			
			
			var route = document.getElementById("routeName").value;
			if( route == "${routeCosts[0].routeName}")
				document.getElementById("amount").value = "${routeCosts[0].amount}";
				else if(route == "${routeCosts[1].routeName}")
					document.getElementById("amount").value = "${routeCosts[1].amount}";
					else if(route == "${routeCosts[2].routeName}")
						document.getElementById("amount").value = "${routeCosts[2].amount}";
						else
							document.getElementById("amount").value = "";
						
						
			
			
			function setRouteCost()
			{
				var route = document.getElementById("routeName").value;
				if( route == "${routeCosts[0].routeName}")
					document.getElementById("amount").value = "${routeCosts[0].amount}";
					else if(route == "${routeCosts[1].routeName}")
						document.getElementById("amount").value = "${routeCosts[1].amount}";
						else if(route == "${routeCosts[2].routeName}")
							document.getElementById("amount").value = "${routeCosts[2].amount}";
						else
							document.getElementById("amount").value = "";
						
				
			}
			
		
		
		</script>


</head>

<body>


		<div class="container-fluid">
			
			<br> <br> <br> <br> 
			<div class="row">
			
				<div class="col-md-offset-3 col-md-4"> 
				
					<form class="form-default" role="form" action="saveRouteCost" method="post" >
			
						<div class="panel panel-info">
									
							<fieldset>	
								
								<div class="panel-heading "> <legend align="center"> <strong> Route Cost </strong> </legend> </div>
								
								<div class="panel-body">
								
									<%-- <div class="row form-group">
										<div class="col-md-4"> <input type="hidden" class="form-control" name="userName" value="${userName}" /> </div>
									</div> --%>
								
									<div class="row form-group">
										<div class="col-md-3"> <label class="control-label" for="routeName"> Route : </label> </div>
										<div class="col-md-7"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-map-marker"> </i> </span>
												<select class="form-control" name="routeName" id="routeName" onchange="setRouteCost()"> 
													<option disabled> Select Route </option>
													<option value="Rajapalayam">Rajapalayam  </option>
													<option value="Srivilliputur"> Srivilliputur </option>
													<option value="Sivakasi">Sivakasi </option>
												</select> 
											</div>
										</div>
									</div>
									
									
									
									
									
									<div class="row form-group">
										<div class="col-md-3"> <label class="control-label" for="amount"> Fee : </label> </div>
										<div class="col-md-7"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-briefcase"> </i> </span>
												<input type="number" class="form-control" name="amount" id="amount"  /> 
										
											</div>
										</div>
									</div>

									<!-- <div class="row form-group">
										<div class="col-md-4"> <label class="control-label" for="confirm"> Confirm Password : </label> </div>
										<div class="col-md-8"> 
											<div class="input-group">
												<span class="input-group-addon"> <i class="glyphicon glyphicon-link"> </i> </span>
												<input type="password" placeholder="Confirm Password" class="form-control" name="confirm" required> 
										
											</div>
										</div>
									</div> -->
							
								</div>
								
							</fieldset>
							
							<div class="row form-group">
								<div class="col-md-offset-6">
									<button type="submit" class="btn btn-success"> Save or Update </button> 
									<button type="button" class="btn btn-danger" onClick="cancel()"> Cancel </button> 
								</div>
							</div>
							
						</div>
						
					</form>
				
				</div>
			
			</div>
					
		</div>
		
	</body>
	
</html>
	<%-- <div class="container-fluid">		
		<h3>  <strong> Trip Route Cost </strong>  </h3>		
	</div>

	<div class="row">
			
				<div class="col-md-offset-1 col-md-9"> 
				
					<form class="form-default" role="form" action="saveRouteCost" method="post">
			
						<div class="page-header">											
							
							<div class="row form-group">
								<label class="control-label col-md-3" for="fee"> Rajapalayam : </label> 
								<input type="hidden" name="adminRouteCostModels[1].routeName" value="rajapalayam"/>
								<div class="col-md-7"> <input type="number" class="form-control"  name="adminRouteCostModels[0].amount" value="${ routeCosts[0].amount}"> </div>
							</div>
							
							<div class="row form-group">
								<label class="control-label col-md-3" for="fee"> Srivilliputhur : </label> 
								<input type="hidden" name="adminRouteCostModels[1].routeName" value="srivilliputhur"/>
								<div class="col-md-7"> <input type="number" class="form-control"  name="adminRouteCostModels[1].amount" value="${ routeCosts[1].amount}"> </div>
							</div>
							
							<div class="row form-group">
								<label class="control-label col-md-3" for="fee"> Sivakasi : </label> 
								<input type="hidden" name="adminRouteCostModels[2].routeName" value="sivakasi"/>
								<div class="col-md-7"> <input type="number" class="form-control"  name="adminRouteCostModels[2].amount" value="${ routeCosts[2].amount}"> </div>
							</div>
								
							
							
																			
						</div>
						
						<div class="row form-group">
							<div class="col-md-offset-9">
								<button type="submit" class="btn btn-success"> Save or Update </button> 
								<button type="button" class="btn btn-danger" onClick="cancel()"> Cancel </button> 
							</div>
						</div>
						
					</form>
				
				</div>
			
			</div>


</body>
</html> --%>