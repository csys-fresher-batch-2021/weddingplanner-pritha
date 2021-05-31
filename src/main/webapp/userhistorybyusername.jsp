<%@page import="in.pritha.dto.UserHistoryDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-userdetailslistbyusername</title>
</head>
<body>
<%
UserHistoryDTO userhistory = (UserHistoryDTO) request.getAttribute("USERHISTORY");
out.println(userhistory);
%>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	
	
	<h2>USER HISTORY</h2>
<table class="table table-bordered">
<caption> User History </caption>
<thead>
<tr><th scope="col">Username </th> <th scope="col">Booking Id </th> <th scope="col"> Amount</th> <th scope="col"> Booking Date </th>
<th scope="col"> Payment date </th> </tr>
</thead>
<tbody id="booking-tbl">
<% if(userhistory !=null ){ %>
<tr>
<td><%=userhistory.getUserName()%>
<td><%=userhistory.getBookingId() %></td>
<td><%=userhistory.getAmount()%></td>
<td><%=userhistory.getBookingDate() %></td>
<td><%=userhistory.getPaymentDate() %></td>



<% } %>
</tbody>
</table>



</main>
</body>
</html>