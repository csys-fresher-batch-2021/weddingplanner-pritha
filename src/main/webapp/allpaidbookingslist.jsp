<%@page import="in.pritha.model.Payment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-allpaidbookingdetails</title>
<style>
#heading {
	color: #2E8B57;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">ALL PAID BOOKING LIST</h3>
	<table class="table table-bordered">
	<caption>All Paid Bookings List</caption>
	<thead>
	<tr><th scope="col">S.no</th><th scope="col">Username</th><th scope="col">Booking Id</th><th scope="col">CardType</th><th scope="col">Amount</th><th scope="col">Status</th>
	<th scope="col">Transaction code</th></tr>
	</thead>
	<tbody>
	<%
	List<Payment> allPaidBookingsList = (List<Payment>) request.getAttribute("ALLPAIDBOOKINGLIST");
	if(allPaidBookingsList!=null) {
		int i=0;
	for (Payment payment : allPaidBookingsList) {
			i++;
	
	%>
	<tr>
	<td><%=i %></td>
	<td><%=payment.getUserName() %></td>
	<td><%=payment.getBookingId() %></td>
	<td><%=payment.getCardType() %></td>
	<td><%=payment.getAmount() %></td>
	<td><%=payment.getStatus() %></td>
	<td><%=payment.getTransactionCode() %></td>
	
	</tr>
	<% 
	}
	}
	
	%>


</tbody>
</table>
	
	<br><br/>
</main>

</body>
</html>