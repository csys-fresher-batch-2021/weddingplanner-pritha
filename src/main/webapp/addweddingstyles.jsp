<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-addweddingstyles</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Wedding Styles</h3>
		<form action="AddWeddingStylesServlet">
			<label for="Wedding Style Name"><b>Wedding Style Name</b></label> 
			<input type="text" name="styleName" placeholder="eg.(Traditional Wedding)"
				pattern="{1,30}"
				onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || (event.charCode==32)"
				title="Only letters (either case),allows spaces, not more than 30 characters"
				required autofocus /> <br />
				 <i>Hint: Only letters (either
				case),allows spaces,not more than 30 characters </i> <br /><br/>
			<label for="Wedding Package"><b>Package</b></label> 
			<input type="number" name="package" placeholder="eg.(100000)"
				pattern="[0-9]{1,10} " title="Only numbers,not more than 10 charcters"
			required autofocus /> <br />
			 <i>Hint: Only numbers,not more than 10 charcters</i> <br /><br/>
			<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>