<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	<h3 id="heading">WEDDING DECOR THEMES</h3>
	<% 
	String infoMessage =(String) request.getAttribute("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>
	<div class="card bg-dark text-white">
  <img class="card-img" alt="romantic" src="assets/img/rom.jpg" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Romantic Garden</h5></strong>
    <p class="card-text">A temple wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
    <strong><p class="text-danger">Package - Rs. 100000</p></strong>
    <a href="RedirectBookingServlet?value=romantic&jsp=booking.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Vintage" src="assets/img/vin.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Vintage Style</h5></strong>
    <p class="card-text">A Museum hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 200000</p></strong>
   <a href="RedirectBookingServlet?value=vintage&jsp=booking.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Light" src="assets/img/lit.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Light_Camera_Action</h5></strong>
    <p class="card-text">A hotel wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 200000</p></strong>
   <a href="RedirectBookingServlet?value=light&jsp=booking.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="sea" src="assets/img/sea.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Under the Sea</h5></strong>
    <p class="card-text">A bouquet hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 500000</p></strong>
   <a href="RedirectBookingServlet?value=sea&jsp=booking.jsp" class="btn btn-primary">Add To Cart</a>
  
  </div>
</div>
<br><br><br>
<div class="card bg-dark text-white">
  <img class="card-img" alt="Forest" src="assets/img/for.jfif" alt="Card image">
  <div class="card-img-overlay">
   <strong> <h5  class="text-danger">Magical Forest</h5></strong>
    <p class="card-text">A historic hall wedding focuses on the marrying couple’s heritage, and fuses culture and a party atmosphere to ring in a new marriage. It’s all about incorporating traditions from both cultures, and often little consideration is given to the overall cost of the wedding.</p>
   <strong> <p  class="text-danger">Package - Rs. 600000</p></strong>
   <a href="RedirectBookingServlet?value=forest&jsp=booking.jsp" class="btn btn-primary">Add To Cart</a>
  </div>
</div>
<br><br><br>



	

</main>
</body>
</html>