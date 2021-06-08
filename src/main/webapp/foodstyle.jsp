<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    #heading { color: #2E8B57; }
  </style>
</head>
 <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../../assets/css/sidebar.css">
        <title>GRACEWED</title>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">WEDDING FOOD STYLES</h3>
	<% 
	String infoMessage = (String) request.getAttribute("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>
	
<div class="card bg-dark text-white">
  <img class="card-img" alt="Plated" src="assets/img/Plated.jpg" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Plated Sit-down</h5></strong>
    <p class="card-text">A Museum hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 200000</p></strong>
   <a href="RedirectBookingServlet?value=plated&jsp=decor.jsp" class="btn btn-primary">Add To Cart</a>
   //call servlet-store in session redirect to next page said by jsp//
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="family" src="assets/img/fam.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Family Style Food</h5></strong>
    <p class="card-text">A temple wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
    <strong><p class="text-danger">Package - Rs. 100000</p></strong>
    <a href="RedirectBookingServlet?value=family&jsp=decor.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Buffet" src="assets/img/buffet.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Buffet</h5></strong>
    <p class="card-text">A hotel wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 200000</p></strong>
   <a href="RedirectBookingServlet?value=buffet&jsp=decor.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Cock Style" src="assets/img/cock.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Cocktail Style </h5></strong>
    <p class="card-text">A bouquet hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 500000</p></strong>
   <a href="RedirectBookingServlet?value=cock&jsp=decor.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Food Stations" src="assets/img/station.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Food Stations</h5></strong>
    <p class="card-text">A historic hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 600000</p></strong>
   <a href="RedirectBookingServlet?value=station&jsp=decor.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>



	

</main>
</body>
</html>