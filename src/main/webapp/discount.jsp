<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-disocunt</title>
<style>
  #heading { color: #2E8B57; } /*green*/
    
}

body {
  font-family: Arial;
   padding-left: 20px
}

.coupon {
  border: 5px dotted #bbb;
  width: 50%;
  border-radius: 15px;
  margin: 0 auto;
  max-width: 400px;
  height: 120px;
 

}

.container {
  padding: 2px 16px;
  background-color: #f1f1f1;
  
}

.promo {
  background: #ccc;
  padding: 3px;
}

.expire {
  color: red;
}
h1 {text-align: center;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1 id="heading" >DISCOUNT</h1>
		<% 
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>
	<%
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<p style='font-size:40px'>&#128543<font color = '#F32013'>"+errorMessage+"</font></p>");
		
		
	}
	%>
	<%
	String earnedCoins =  request.getParameter("earnedCoins");
	%> 
	<p>   <font color ='#008000'> Earned Coins :<%=earnedCoins %></font></p>
		
		 <div class="coupon">
  <div class="container">
    <h3>***USE YOUR DISCOUNT***</h3>
  </div>
  <img src="assets/img/formal.jpg" alt="Avatar" style="width:100%;">
  <div class="container" style="background-color:white">
    <h2><b>20% OFF YOUR PURCHASE</b></h2> 
    <p>You can use this promocode while payment to get discount to land your dream wedding!</p>
  </div>
  <div class="container">
    <p>Use Promo Code: <span class="promo">BOH232</span></p>
    <p class="expire">Expires: Jan 03, 2021</p>
  </div>
</div>
		
</main>		
</main>		
</body>
</html>