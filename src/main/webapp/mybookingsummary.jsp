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

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">***BUDGET FOR YOUR DESIGNED OCCASION****</h3>
	<br><br/>
	
	<h2>List Booking details</h2>
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
<%-- <%

String bookedUserName = (String)session.getAttribute("BookedUserName");
%> --%>
<script>
function getAllBookingDetails(){
	console.log("Fetching all details ");
	
	//Previous Page => Data => query params ???
			
			//let username = pritha ;
			//console.log(username);
	//let date = "2021-05-01";
	//let time ="05:06:32";
	//let queryParams = "?BookingUsername=" +userName;
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
getAllBookingDetails();

	
	
 </script>
 

	
</main>
</body>
</html>