<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title>GRACEWED-budgetestimation</title>
<style>
    #heading { color: #2E8B57; } /*green*/
    
}


</style>
</head>
<body>
<%
String bookedUserName = (String)session.getAttribute("VerfiedLoggedInUser");
%>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">My All Booking Summary</h3>
	<br><br/>
	
	<font color = "red">Number Of Bookings  <span id="number"> </span>
   </font>    
        <br><br>
     <button type="button" onclick="discountEligibilityCheck()">Click here to see if you are eligibilt for discount...></button>  

<br><br>
<table class="table table-bordered">
<caption> My All Booking Summary </caption>
<thead>
<tr><th scope="col">Booking Id</th><th scope="col">Status</th><th scope="col">Username </th> <th scope="col"> Wedding Date </th> <th scope="col"> Wedding Time </th>
<th scope="col"> Wedding Location </th> <th scope="col"> Wedding Style </th> <th scope="col"> Weddingstyle Location</th>
<th scope="col">Wedding FoodType </th> <th scope="col"> Wedding Guest Count </th><th scope="col"> Wedding Decor type </th>
</tr>
</thead>
<tbody id="booking-tbl">
</tbody>
</table>




 
<script>
function getAllBookingDetails(){
	console.log("Fetching all details ");
	
	let url = "ListBookingServlet"; //+ queryParams;
	
		fetch(url).then(res=> res.json()).then(res=>{
		let bookingdetails = res;
		console.log("Got response from servlet");
		console.log(bookingdetails);
		let content = "";
		for(let details of bookingdetails){
			content += "<tr>";
			content += "<td> " + details.booking_id+"</td>";
			content += "<td> " + details.status+"</td>";
			content += "<td> " + details.userName  +"</td>";
			content += "<td>"+details.weddingDate+"</td>";
			
					content += "<td>" +details.weddingTime +"</td>";
					content += "<td>"+details.weddingLocation+" </td>";
						content += "<td>" +details.weddingStyle+" </td>";
						content += "<td>"+ details. weddingStyleLocation+" </td>";
							content += "<td> "+details.weddingFoodType+"</td>"
							content +="<td>"+details.weddingGuestCount+ "</td>";
								content += "<td>" +details.weddingDecorType+ "</td>"; 
									content += "</tr>";
			
		}
		console.log(content);
		document.querySelector("#booking-tbl").innerHTML= content;
	});
}


	
	
 
 function getNumberOfBookings(){
		console.log("Fetching all details ");
		let url = "NumberOfBookingsServlet?VerfiedLoggedInUser=<%=bookedUserName%>"; 
		
			fetch(url).then(res=> res.json()).then(res=>{
				
			let numberOfBookings = res;
			console.log("Got response from servlet", res);
			localStorage.setItem("number_bookings", numberOfBookings);
		
			console.log(numberOfBookings);
			
			 //It returns the value that is stored in localstorage object
            document.querySelector("#number").innerHTML = localStorage.getItem("number_bookings");
			});
 }
 
 function discountEligibilityCheck(){
	 var numberOfBookings = localStorage.getItem("number_bookings");
	 
	console.log("NUMBEROFBOOKINGS"+numberOfBookings);
     if (numberOfBookings>=10) {
    	 document.write("Congrats! You are eligibile for discount");
    	 window.location.replace("discount.jsp"); 
         //It stores the value in localStorage object with a key//
         // So, fare is stored to print outside the method or class //
 }
     else{
    	 alert("Sorry! You are not eligible for discount");
    	 }
     }
 getNumberOfBookings();
 getAllBookingDetails();
 
 
 </script>
 

	
</main>
</body>
</html>