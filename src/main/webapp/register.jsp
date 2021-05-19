
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-register</title>
<style>
#heading {
	color: #FA8072;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 id="heading">Register</h3>
		<br>

		<form action="RegisterServlet" method="get">
			<label for="Username"><strong>USERNAME</strong></label><br> <input
				type="text" name="Username" id="Username"
				title="Username must be lowercase characters and length should be(4-8)"
				placeholder="Username" pattern="[a-z]{4,8}" required autofocus>
			<p id="heading">
				<em>Hint : Username must be lowercase and 4-8 characters in
					length.</em>
			</p>
			<label for="mobileno"><strong>MOBILE NO</strong></label><br> <input
				type="tel" name="phone_number" id="phone_number" pattern="^\d{10}$"
				required="required" />
			<p id="heading">
				<em>Hint : Mobile No must be 10 digits</em>
			</p>
			<label for="Password"><strong>PAASWORD</strong></label> <input
				type="password" name="Password"
				title="Your Password must be like this eg.Prit@7172" id="Password"
				placeholder="Password" pattern=".{8,20}" required autofocus>
			<p id="heading">
				<em>Hint :Your Password must be like this eg.Prit@7172</em>
			</p>
			<button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
		</form>
	</main>
</body>
</html>