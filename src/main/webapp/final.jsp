<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-final</title>
  
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 id="heading">Final PAGE</h3>
	<% 
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font color ='#008000'>"+infoMessage+"</font>");
	}
	
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<p style='font-size:40px'>&#128543<font color = '#F32013'>"+errorMessage+"</font></p>");
		
		
	}
	%>
	<%
	session.removeAttribute("FARE");
	session.removeAttribute("BookedUserName");
	session.removeAttribute("BOOKING_ID");
	session.removeAttribute("WEDDINGSTYLECHOOSEN");
	session.removeAttribute("LOCATIONSTYLECHOOSEN");
	session.removeAttribute("FOODSTYLECHOOSEN");
	session.removeAttribute("FOODSTYLECHOOSEN");
	session.removeAttribute("DECORSTYLECHOOSEN");
	%> 
	
	
	
	
	
	
	
 
    

               



   
        

</main>
</body>
</html>