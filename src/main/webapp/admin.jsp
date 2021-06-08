<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../../assets/css/sidebar.css">
<meta charset="ISO-8859-1">
<title>Gracewed-admin</title>
</head>
<body>
<div class="p-3 mb-2 bg-info text-white">ADMIN PAGE</div>
<ul class="nav justify-content-end">

<li class="nav-item">
    <a class="nav-link active" href="#">*</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="ViewAllBookingDetailsServlet">ALL BOOKINGS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="ListCancelledBookingServlet">CANCELLED BOOKINGS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="ListConfirmedBookingServlet">CONFIRMED BOOKINGS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="ListPaidBookingsServlet">PAID BOOKINGS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="leaderboardbooking.jsp">LEADERBOARD</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="LogoutServlet">LOGOUT</a>
  </li>
</ul>




       
</body>
</html>