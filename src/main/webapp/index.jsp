<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>GRACEWED-index</title>
<style>
      .multicolortext {
        background-image: linear-gradient(to left, violet, indigo, green, blue, yellow, orange, red);
}
 </style>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br><br/>
		<h1>
		<span class="multicolortext">WELCOME TO GRACEWED!</span>
		</h1>
		<br/><br/>
		<h3>WE make your DREAMS True...</h3>
		<br><br>
		<%
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<p style='font-size:40px'>&#128543<font color = '#F32013'>"+errorMessage+"</font></p>");
		
		
	}
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage!=null){
		out.println("<p style='font-size:40px'>&#128525<font colour ='#008000'>"+infoMessage+"</font>");
	}
	%>

	</main>
</body>
</html>
