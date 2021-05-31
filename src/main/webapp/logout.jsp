<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-logout</title>

<style>
    #heading { color: #2E8B57; } /*green*/
    
}

</style>
 <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">***LOGOUT****</h3>
	<br><br/>
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
	
     <br>
	<a href="LoginJSP.jsp">You can Login here</a>
	
</main>
</body>
</html>