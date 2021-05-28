<%@page import="in.pritha.model.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-allcancelledbookinglist</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">ALL CONFIRMED BOOKING LIST</h3>
	<table class="table table-bordered">
	<caption> All Cancelled Bookings List</caption>
	<thead>
	<tr><th scope="col">S.no</th><th scope="col">Booking Id</th><th scope="col">Cancellation Reason<th scope="col">Status</th><th scope="col">Username</th><th scope="col">Wedding Date</th><th scope="col">Wedding Time</th>
	<th scope="col">Wedding Location</th><th scope="col">Wedding Style</th><th scope="col">WeddingStyle Location</th><th scope="col">Food Count</th><th scope="col">Guest Count</th>
	<th scope="col">Decoration theme</th></tr>
	</thead>
	<tbody>
	<%
	List<Booking> allConfirmedBookingsList = (List<Booking>) request.getAttribute("ALLCANCELLEDBOOKINGLIST");
	if(allConfirmedBookingsList!=null) {
		int i=0;
	for (Booking booking : allConfirmedBookingsList) {
			i++;
	
	%>
	<tr>
	<td><%=i %></td>
	<td><%=booking.getBooking_id() %></td>
	<td><%=booking.getCancellationReason() %></td>
	<td><%=booking.getStatus() %></td>
	<td><%=booking.getUserName() %></td>
	<td><%=booking.getWeddingDate() %></td>
	<td><%=booking.getWeddingTime() %></td>
	<td><%=booking.getWeddingLocation() %></td>
	<td><%=booking.getWeddingStyle() %></td>
	<td><%=booking.getWeddingStyleLocation() %></td>
	<td><%=booking.getWeddingFoodType() %></td>
	<td><%=booking.getWeddingGuestCount() %></td>
	<td><%=booking.getWeddingDecorType() %></td>
	</tr>
	<% 
	}
	}
	
	%>


</tbody>
</table>
	</main>
</body>
</html>