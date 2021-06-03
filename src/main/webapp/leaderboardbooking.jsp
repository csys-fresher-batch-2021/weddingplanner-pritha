<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-leaderboardbooking</title>
<style>
    #heading { color: #2E8B57; }
  </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">LEADERBOARD</h3>
	<br>
	<table class="table table-bordered">
<caption>LEADERBOARD-BOOKING </caption>
<thead>
<tr><th scope="col">USERNAME</th><th scope="col">NO OF BOOKINGS</th><th> Rank </th>
</tr>
</thead>
<tbody id="booking-tbl">
</tbody>
</table>

<script>
function getNoOfBookings(){
	console.log("Fetching all details ");
	
	
	let url="LeaderBoardBookingsServlet"; 
	
		fetch(url).then(res=> res.json()).then(res=>{
		let noofbookings = res;
		console.log("Got response from servlet");
		console.log(noofbookings);
		let content = "";
		var i=1;
		for(let key of noofbookings){
			
			//let value = noofbookings[key]; //map.get(key)
			content += "<tr>";
			content += "<td> " + key.username +"</td>";
			content += "<td> " + key.noOfBookings +"</td>";
			content += "<td> " + i++ +"</td>";
			content += "</tr>";
			
		}
		console.log(content);
		document.querySelector("#booking-tbl").innerHTML= content;
	});
}
getNoOfBookings();
</script>

</main>

</body>
</html>