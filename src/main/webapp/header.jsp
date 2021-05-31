<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<!-- 
jquery.min.js
bootstrap.min.js
 -->
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%
String loggedInUserName = (String)session.getAttribute("VerfiedLoggedInUser");
String role = (String)session.getAttribute("Role");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">GRACEWED</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListWeddingStyleServlet">Wedding Styles</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="ListWeddingLocationsServlet">Wedding Locations</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Additional Contracts</a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Photography</a>
          <a class="dropdown-item" href="#">Music and Entertainment</a>
          <a class="dropdown-item" href="#">FireWorks</a>
          <a class="dropdown-item" href="#">Royal Procession</a>
          <a class="dropdown-item" href="#">Luxurious Travel and Transport</a>
        </div>
      </li>
    </ul>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
     <% if(loggedInUserName ==null && role == null){ %>
      <li class="nav-item active">
        <a class="nav-link" href="LoginJSP.jsp">Login</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="register.jsp">Register</a>
      </li>
       <% } 
       else if(loggedInUserName.equalsIgnoreCase("admin") && loggedInUserName!=null){ %>
      <li class="nav-item active">
        <a class="nav-link" href="ViewAllBookingDetailsServlet">VIEW ALL BOOKINGS</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ListConfirmedBookingServlet">VIEW CONFIRMED BOOKINGS</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ListCancelledBookingServlet">VIEW CANCELLED BOOKINGS</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ListPaidBookingsServlet">VIEW PAID BOOKINGS</a>
      </li>
       <% }
      else { %>
      <li class="nav-item">
        <a class="nav-link" href="#">Welcome <%=loggedInUserName %></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="booking.jsp">Booking</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="mybookingsummary.jsp">My Bookings</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListUserHistoryServlet">My Account</a>
      </li>
      <% } %>
      </ul>
     
   
  </div>
</nav>
</header>