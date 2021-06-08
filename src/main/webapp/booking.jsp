<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-booking</title>
<style>
#heading {
	color: #2E8B57;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1 id="heading">BOOKING</h1>
		<br>
		<br />
		<% 
	String infoMessage = (String) request.getAttribute("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>
		<%
	String inforMessage = request.getParameter("inforMessage");
	if(inforMessage!=null){
		out.println("<p style='font-size:40px'>&#128543<font color = '#F32013'>"+inforMessage+"</font></p>");
		
	}
	%>
	<%
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<p style='font-size:40px'>&#128543<font color = '#F32013'>"+errorMessage+"</font></p>");
		
		
	}
	
	%> 
	<%
	System.out.println("booking entered");
	String foodChoosen = (String) session.getAttribute("FOODSTYLECHOOSEN");
	System.out.println(foodChoosen);
	String decorChoosen =(String) session.getAttribute("DECORSTYLECHOOSEN");
	System.out.println(decorChoosen);
	String locationChoosen =(String) session.getAttribute("LOCATIONSTYLECHOOSEN");
	System.out.println(locationChoosen);
	String weddingStyleChoosen =(String) session.getAttribute("WEDDINGSTYLECHOOSEN");
	System.out.println(weddingStyleChoosen);
	
	%>
		<form action="BookingServlet">
			<div class="row">

				<div class="col-6">
					<label for="Username"><strong>Enter your Username *</strong></label>
					<input type="text" name="BookingUsername" id="Username"
						title="Username can be either case characters and length should be(4-8)"
						placeholder="Username" pattern="[a-zA-Z]{4,20}" required autofocus>
					<br /> <br /> <label for="weddingdate"><strong>Select
							Your Wedding Date *</strong> </label> <input name='wdate' id='wdate' type='date'
						value='2021-05-21'  required>
						
	<script>
	
	function minDate(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0 so need to add 1 to make it 1!
		var yyyy = today.getFullYear();
		if(dd<10){
		  dd='0'+dd
		} 
		if(mm<10){
		  mm='0'+mm
		} 

		today = yyyy+'-'+mm+'-'+dd;
		document.getElementById("wdate").setAttribute("min", today);
	}
	minDate();
	</script>
					<ul>
						<li><em> Note <br></br> Date should be above today!
								

						</em></li>
					</ul>
					<br> <label for="weddingtime"><strong>Select
							your Wedding Time *</strong></label> <input name='wtime' id='wtime' type="time"
						value="04:00:00" min="04:00:00" max="16:00:00" required> <br>
					<br />
					<ul>
						<li><em> Note <br></br> Time should be between 4 AM to 4
								PM

						</em></li>
					</ul>
					<br /> <label><strong>Enter Your Wedding Location *</strong></label>
					<br /> <input type="text" name="wloc" id="wloc"
						placeholder="Your wedding location" required> <br />
					<br />


				</div>

				<div class="col-6">
					<label for="weddingstyles"><strong>Choose a
							Wedding Style *</strong></label> <select name="weddingstyles" id="weddingstyles"
						required>
						<option disabled selected>Choose a Wedding Style</option>
						<% if(weddingStyleChoosen.equals("VintageStyle wedding")) {%>
						<option value="VintageStyle wedding" selected>VintageStyle wedding</option>
						<% }else if(weddingStyleChoosen.equals("Traditional Wedding")){ %>
						<option value="Traditional Wedding" selected>Traditional Wedding</option>
						<% }else if(weddingStyleChoosen.equals("Informal Wedding")){ %>
						<option value="Informal Wedding" selected>Informal Wedding</option>
						<% }else if(weddingStyleChoosen.equals("Formal Wedding")){ %>
						<option value="Formal Wedding" selected>Formal Wedding</option>
						<% }else if(weddingStyleChoosen.equals("Festival Wedding")){ %>
						<option value="Festival Wedding" selected>Festival Wedding</option>
				<%} else{ %>
				<option value="VintageStyle wedding">VintageStyle wedding</option>
				<option value="Traditional Wedding">Traditional Wedding</option>
				<option value="Informal Wedding">Informal Wedding</option>
				<option value="Formal Wedding">Formal Wedding</option>
				<option value="Festival Wedding">Festival Wedding</option>
				<%} %>
					</select> <br />
					<br /> <br /> <label for="weddinglocations"><strong>Choose
							a Wedding Location *</strong></label> <select name="locations" id="locations"
						required>
						<option disabled selected>Choose a Wedding Location</option>
						<%if(locationChoosen.equals("alone")){ %>
						<option value="Stand Alone Bouquet Hall" selected>Stand Alone
							Bouquet Hall</option>
						<% }else if(locationChoosen.equals("hotel")){ %>
						<option value="Hotel" selected>Hotel</option>
						<% }else if(locationChoosen.equals("temple")){ %>
						<option value="Temple/Mahal" selected>Temple/Mahal</option>
						<% }else if(locationChoosen.equals("museum")){ %>
						<option value="Museum" selected>Museum</option>
						<% }else if(locationChoosen.equals("historic")){ %>
						<option value="Historic site" selected>Historic site</option>
						<%} else {%>
						<option value="Stand Alone Bouquet Hall">Stand Alone
							Bouquet Hall</option>
							<option value="Hotel">Hotel</option>
							<option value="Temple/Mahal">Temple/Mahal</option>
							<option value="Museum">Museum</option>
							<option value="Historic site">Historic site</option>
							<% }%>
					</select> <br />
					<br />
					<br /> <label for="Food"><strong>Choose Kind of
							Food *</strong></label> <select name="food" id="food" required>
						<option disabled selected>Choose Kind of Food</option>
						<%if(foodChoosen.equals("family")){ %>
						<option value="Family Style" selected>Family Style</option>
						<% }else if(foodChoosen.equals("plated")){ %>
						<option value="Plated Sit-Down" selected>Plated Sit-Down</option>
						<% }else if(foodChoosen.equals("buffet")) { %>
						<option value="Buffet" selected>Buffet </option>
						<%} else if (foodChoosen.equals("cock")){ %>
						<option value="Cocktail-Style" selected>Cocktail-Style</option>
						<% } else if(foodChoosen.equals("station") ){%>
						<option value="Food Stations" selected>Food Stations</option>
						<%} else {%>
						<option value="Family Style" >Family Style</option>
						<option value="Plated Sit-Down" >Plated Sit-Down</option>
						<option value="Buffet" >Buffet </option>
							<option value="Cocktail-Style" >Cocktail-Style</option>
							<option value="Food Stations" >Food Stations</option>
							<% }%>
					</select> <br />
					<br />
					<br /> <label for="guest"><strong>Choose Guest
							Count</strong></label> <select name="guest" id="guest" required>
						<option disabled selected>Choose Guest Count</option>
						<option value="10">10</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="500">500</option>
						<option value="1000">1000</option>
					</select> <br /> <em>Due to Current Pandemic Situation, Select upto
						100! </em> <br />
					<br />
					<br /> <label for="guest"><strong>Choose
							Decoration theme *</strong></label> <select name="decor" id="decor" required>
						<option disabled selected>Choose Decoration theme</option>
						<%if(decorChoosen.equals("romantic")){ %>
						<option value="Romantic Garden" selected>Romantic Garden</option>
						<%} else if(decorChoosen.equals("vintage")){ %>
						<option value="Vintage Travel" selected> Vintage Travel</option>
						<%} else if(decorChoosen.equals("light")){ %>
						<option value="Lights-Camera-Action" selected>
							Lights-Camera-Action</option>
						<%} else if(decorChoosen.equals("sea")){ %>
						<option value="Under the Sea" selected>Under the Sea</option>
						<%} else if(decorChoosen.equals("forest")){ %>
						<option value="Magical forest" selected>Magical forest</option>
						<% } else { %>
						<option value="Romantic Garden" >Romantic Garden</option>
						<option value="Vintage Travel">Vintage Travel</option>
					<option value="Lights-Camera-Action">
							Lights-Camera-Action</option>
							<option value="Under the Sea" >Under the Sea</option>
							<option value="Magical forest">Magical forest</option>
							<%} %>
							
					</select> <br />

</div>

				</div>

			
			<button type="submit" class="btn btn-primary"
				style="margin-left: 40%">submit</button>





		</form>
		
	</main>
</body>
</html>