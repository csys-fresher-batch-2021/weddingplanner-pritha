<%@page import="in.pritha.model.Booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title>GRACEWED-budgetestimation</title>
<style>
    #heading { color: #2E8B57; } /*green*/
    
}
.hide{
  display:none;
}
.show{
  display:block;
}

</style>
</head>
<body>

<%
Booking booking = (Booking) session.getAttribute("BOOKING_DETAIL");
out.println(booking);
%>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">***BUDGET FOR YOUR DESIGNED OCCASION****</h3>
	<br><br/>
	
	<h2>List Booking details</h2>
<table class="table table-bordered">
<caption> My Last Booking Summary </caption>
<thead>
<tr><th scope="col">Booking Id </th> <th scope="col">Booked Username </th> <th scope="col"> Wedding Date </th> <th scope="col"> Wedding Time </th>
<th scope="col"> Wedding Location </th> <th scope="col"> Wedding Style </th> <th scope="col"> Weddingstyle Location</th>
<th scope="col">Wedding FoodType </th> <th scope="col"> Wedding Guest Count </th><th scope="col"> Wedding Decor type </th><th scope="col"> Status </th>
</tr>
</thead>
<tbody id="booking-tbl">
<% if(booking !=null ){ %>
<tr>
<td><%=booking.getBooking_id() %>
<td><%=booking.getUserName() %></td>
<td><%=booking.getWeddingDate()%></td>
<td><%=booking.getWeddingTime() %></td>
<td><%=booking.getWeddingLocation() %></td>
<td><%=booking.getWeddingStyle() %></td>
<td><%=booking.getWeddingStyleLocation() %></td>
<td><%=booking.getWeddingFoodType() %>,</td>
<td><%=booking.getWeddingGuestCount() %></td>
<td><%=booking.getWeddingDecorType() %></td>
<td><%=booking.getStatus() %></td>

<% } %>
</tbody>
</table>
<br><br><br>
<button type="submit"  value="goto" class="btn btn-danger" onclick="cancel()" >CANCEL BOOKING</button>

<br><br>


 <%
	Integer fare = (Integer) request.getAttribute("FARE");
	if(fare!=null) {
	%>
	<br><br>
	<em ><strong id="heading">Estimated Budget : <%=fare %> Rs.</strong></em>
	<%
	}    
	%>
	<br><br> 
	 <a href="onlinepayment.jsp?fare=<%=fare %>" > Click here to proceed for Online Payment.. </a>  
	<script>
	 function cancel() {
	       window.location.href="http://localhost:8080/app/cancelbooking.jsp";  
	     }
	
	</script> 
	
	 
</main>
</body>
</html>