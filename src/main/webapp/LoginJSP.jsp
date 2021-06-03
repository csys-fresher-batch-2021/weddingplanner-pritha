<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACWED-login</title>
<style>
    #heading { color: #2E8B57; } /*green*/

</style>
<script type="text/javascript">
function back_block() {
window.history.foward(-1)
}
</script>


</head>


<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">Login</h3>
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
<form action="LoginServlet" method="get">
			<label for="Username"><strong>USERNAME</strong></label> 
			<input type="text"
				name="Username" id="Username" title="Username can be either case characters and length should be(4-8)" placeholder="Username"
				pattern="[a-zA-Z]{4,20}" required autofocus> <br /> <br />
			<p id="heading"></p>
			<label for="Password"><strong>PAASWORD</strong></label>
			 <input type="password"
				name="Password" title="Your Password must be like this eg.Prit@7172"  id="Password" placeholder="Password"
				  pattern=".{8,20}" required
				autofocus> <br /> <br />
			<p id="heading"><em></em></p>
			<button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
			<br><br/>
        	<input type="checkbox" name ="rememberMe" checked="checked"> Remember me
        	<br><br/>Forgot<a href="forgetpassword.jsp" > password? </a>
		
	</form>

    
    
   
  

	</main>
</body>
</html>