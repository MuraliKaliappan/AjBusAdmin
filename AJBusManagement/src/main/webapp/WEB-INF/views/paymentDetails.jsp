<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment Details</title>


			<script type="text/javascript">
				function confirmPaid(busTripSerialNo) {
					console.log(busTripSerialNo +" "+true);
					window.location.href = 'savePaymentDetails?busId='+busTripSerialNo+"&status="+true
				}

				function unconfirmPaid(busTripSerialNo) {
					console.log(busTripSerialNo +" "+false);
					window.location.href = 'savePaymentDetails?busId='+busTripSerialNo+"&status="+false
				}


		</script>
</head>

<body>

	<div class="container-fluid">
					<!-- <h3>
						<strong> Student's Trip Selection Summary</strong>
					</h3> -->
				<br> <br> <br>
				
				<div class="row">

					<div class="col-md-offset-1 col-md-9">

						<form class="form-default" role="form" action="savePaymentDetails" method="post">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Student ID</th>
										<th>Route</th>
										<th>Trip</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:choose>
										<c:when test="${empty busTrips}"><tr> <td colspan="6"> No payment details found</td></tr></c:when>
										<c:otherwise>										
											<c:forEach items="${busTrips}" var="busTrip">
												<tr>
													<td>${busTrip.student.emailId}</td>
													<td>${busTrip.area}</td>
													<td>${busTrip.trip}</td>
													<td><input class="form-contrl btn btn-success"
														type="button" value="Paid"
														onclick="confirmPaid(${busTrip.serialNo})"> <input
														type="button" class="form-contrl btn btn-danger"
														onclick="unconfirmPaid(${busTrip.serialNo})" value="Unpaid"></td>
												</tr>
		
											</c:forEach>
										</c:otherwise>	
									</c:choose>
							

								</tbody>
							</table>

						</form>

					</div>

				</div>

</div>


</body>
</html>