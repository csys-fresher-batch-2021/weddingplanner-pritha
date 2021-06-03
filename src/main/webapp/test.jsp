
<!DOCTYPE html>
<html lang="en">
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
	
<%
String loggedInUserName = (String)session.getAttribute("VerfiedLoggedInUser");
String role = (String)session.getAttribute("Role");
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
                        <img class="card-img-top" src="assets/img/login.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">LOGIN</h5>
                          <p class="card-text">Sign in to explore more!<br><br><br></p>
                          <a href="LoginJSP.jsp" class="btn btn-primary ">Explore</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" src="assets/img/book.png" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">BOOKING</h5>
                          <p class="card-text">Design Your Dream Wedding by booking in India's best Wedding Planar Platform<br></p>
                          <% if(loggedInUserName ==null && role == null){ %>
                          <a href="booking.jsp" class="btn btn-primary">Explore</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" src="assets/img/discount.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">DISCOUNT</h5>
                          <p class="card-text">Get discount for your number of bookings!<br><br><br><br> </p>
                          <a href="discount.jsp" class="btn btn-primary">Explore</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" src="assets/img/login.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">Make Payment</h5>
                          <p class="card-text">Online payment is mandatory* to land your Wedding quickly!<br> </p>
                          <a href="onlinepayment.jsp" class="btn btn-primary">Explore</a>
                        </div>
                      </div>
                </div>
            </div>
        </main>
        
        </main>
    </body>
</html>