<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-forgotpassword</title>
<style>
    #heading { color: #2E8B57; } /*green*/

</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">***FORGET PASSWORD?****</h3>
	<br><br/>
<form action="ForgetPasswordServlet" method="get" >
<label for="Username"><strong>USERNAME</strong></label> 
			<input type="text"
				name="Username" id="Username" title="Username can be either case characters and length should be(4-8)" placeholder="Username"
				pattern="[a-zA-Z]{4,8}" required autofocus> <br /> <br />
<label for="Password"><strong>CREATE PASSWORD</strong>></label> 
<input type="password"
				name="CreatePassword" title="Password must be numeric characters and length should be(8-20)"  id="Password" placeholder="Password"
				inputmode="numeric"  pattern=".{8,20}" required
				autofocus> <br /> <br />
			<p id="heading"><em>Hint : Password must be numeric and 8-20 characters in length</em>></p>
<label for="Password"><strong>CONFIRM PASSWORD</strong>></label> 			
<input type="password"
				name="ConfirmPassword" title="Password must be numeric characters and length should be(8-20)"  id="Password" placeholder="Password"
				inputmode="numeric"  pattern=".{8,20}" required
				autofocus> <br /> <br />
			<button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			
</form>
</main>
</body>
</html>