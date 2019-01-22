<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip Management</title>
			<script type="text/javascript">
				function acceptBusTrip(busTripSerialNo) {
					console.log(busTripSerialNo +" "+true);
					window.location.href = 'saveTripDetails?busId='+busTripSerialNo+"&status="+true
				}

				function declineBusTrip(busTripSerialNo) {
					console.log(busTripSerialNo +" "+false);
					window.location.href = 'saveTripDetails?busId='+busTripSerialNo+"&status="+false
				}


		</script>
</head>

<body>

	<div class="container-fluid">
					<h3>
						<strong> Student's Trip Selection Summary</strong>
					</h3>
				</div>

				<div class="row">

					<div class="col-md-offset-1 col-md-9">

						<form class="form-default" role="form" action="saveTripDetails" method="post">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Student Name</th>
										<th>Degree</th>
										<th>Studying Year</th>
										<th>Route</th>
										<th>Trip</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:choose>
										<c:when test="${empty busTrips}"><tr> <td colspan="6"> No bus trip selection found</td></tr></c:when>
										<c:otherwise>										
											<c:forEach items="${busTrips}" var="busTrip">
												<tr>
													<td>${busTrip.student.studentName}</td>
													<td>${busTrip.student.degree}</td>
													<td>${busTrip.student.studyingYear}</td>
													<td>${busTrip.area}</td>
													<td>${busTrip.trip}</td>
													<td><input class="form-contrl btn btn-success"
														type="button" value="Accept"
														onclick="acceptBusTrip(${busTrip.serialNo})"> <input
														type="button" class="form-contrl btn btn-danger"
														onclick="declineBusTrip(${busTrip.serialNo})" value="Reject"></td>
												</tr>
		
											</c:forEach>
										</c:otherwise>	
									</c:choose>
							

								</tbody>
							</table>

						</form>

					</div>

				</div>



</body>
</html>