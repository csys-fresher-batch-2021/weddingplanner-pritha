<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-cancelbooking</title>
<style>
    #heading { color: #2E8B57; } /*green*/

</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br>
<h3 id="heading">**** CANCELLED BOOKING!****</h3>
<br>
<form action="CancelBookingServlet">
<input id="heading" type="button"  value="REASON FOR CANCELLATION" />
&nbsp; &nbsp;
<input class="hide" type="text" name="reason" id="textInput" required   >





<button type="submit" class="btn btn-success">Submit</button>
<br> 

</form>
<%
Integer bookingid =  (Integer) session.getAttribute("BOOKING_ID");


%>

<em> Your Booking id <%=bookingid%> has been cancelled successfully! </em>

</main>
</body>
</html>