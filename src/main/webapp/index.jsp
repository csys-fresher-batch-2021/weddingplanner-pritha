<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
            function verify(){
               alert("You must Login to explore this");
            }
            </script>
</head>
 <head>
 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../../assets/css/sidebar.css">
        <title>GRACEWED</title>
        <style>
              .multicolortext {
        background-image: linear-gradient(to left, violet, indigo, green, blue, yellow, orange, red);
}
     </style> 
     
    </head>
   
    <body>
    <jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
    <div class="float-right"><br>
	<nav aria-label="Page navigation example">
  <ul class="pagination">
   <li class="page-item"><a class="page-link" href="weddingstyles.jsp"> Wedding Styles</a></li>
    <li class="page-item"><a class="page-link" href="cardweddingstyles.jsp"> Wedding Locations</a></li>
   
    <li class="page-item"><a class="page-link" href="foodstyle.jsp"> Food Styles</a></li>
    <li class="page-item"><a class="page-link" href="decor.jsp">Decoration Themes</a></li>
  </ul>
</nav>
</div>	
<%
String loggedInUserName = (String)session.getAttribute("VerfiedLoggedInUser");
String role = (String)session.getAttribute("Role");
String bookedInUserName = (String)session.getAttribute("BookedUserName");
Integer bookingId = (Integer)session.getAttribute("BOOKING_ID");
Integer fare =(Integer) session.getAttribute("FARE");



%>  
<% 
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>
	<%
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<p style='font-size:40px'>&#128559<font color = '#F32013'>"+errorMessage+"</font></p>");
		
		
	}
	
	%> 
	
		<br>
		<header>
           <h1>
		<span class="multicolortext">WELCOME TO GRACEWED!</span>
		</h1>
        </header>
		<br>
		<h3>WE make your DREAMS True...</h3>
		<br><br>
        
        <main class="">
            <div class="row">
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" alt="Login" src="assets/img/login.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">SIGN UP/LOGIN</h5>
                          <p class="card-text">Sign in to explore more!<br><br><br></p>
                           <% if(loggedInUserName ==null ){ %>
                          <a href="register.jsp" class="btn btn-primary ">Sign Up</a>
                        &nbsp; &nbsp;&nbsp; &nbsp;
                          <a href="LoginJSP.jsp" class="btn btn-primary ">Login</a>
                           <% } else if(loggedInUserName.equalsIgnoreCase("admin") && loggedInUserName!=null){ %>
                           <a href="admin.jsp" class="btn btn-primary ">Explore Admin page</a> 
                           
                        <% }  else { %>
                         <a href="LoginJSP.jsp" class="btn btn-primary ">Login</a>
                       
                        
                         <% } %>
                        </div>
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" alt="Booking" src="assets/img/book.png" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">BOOKING</h5>
                          <p class="card-text">Design Your Dream Wedding by booking in India's best Wedding Planar Platform<br></p>
                          <% if(loggedInUserName !=null ){ %>
                          <a href="weddingstyles.jsp" class="btn btn-primary">Explore</a>
                       <% }   else { %>
   
                        	 <a href="weddingstyles.jsp" class="btn btn-primary disabled onclick="verify()">Explore</a>
                      
                        <% } %>
                        </div>
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" alt="Discount" src="assets/img/discount.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">DISCOUNT</h5>
                          <p class="card-text">Get discount for your number of bookings!<br><br><br><br> </p>
                         <% if(loggedInUserName !=null && fare !=null){ %> 
                          <a href="DiscountServlet" class="btn btn-primary">Explore</a>
                        <% }   else { %>
                          <a href="DiscountServlet" class="btn btn-primary disabled onclick="verify()">Explore</a>
                         <% } %>
                        </div>
                         
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" alt="Payment" src="assets/img/login.jpg" alt="Card image cap">
                        <div class="card-body">
                        
                          <h5 class="card-title">Make Payment</h5>
                          <p class="card-text">Online payment is mandatory* to land your Wedding quickly!<br> </p>
                          <% if(bookedInUserName !=null && bookingId!=0 & fare!=null){ 
                          String informMessage ="You are paying for your last booking!";%>
                          <a href="onlinepayment.jsp?fare=<%=fare %>&informMessage=<%=informMessage %>" class="btn btn-primary">Explore</a>
                       
                        <% } else { 
                         %>
                         <a href="onlinepayment.jsp?" class="btn btn-primary disabled onclick="verify()">Explore</a>
                        <% } %>
                        </div>
                      </div>
                </div>
            </div>
             
            </main>
  </main>         
</html>