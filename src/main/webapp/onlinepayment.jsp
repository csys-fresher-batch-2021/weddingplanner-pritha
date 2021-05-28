<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-onlinepayment</title>
<style>
#heading {
	color: #FA8072;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 id="heading">PAYMENT</h3>
		<br>
		<form action="OnlinePaymentServlet" >
			<label for="cardtypes"><strong>Choose a Card Type </strong></label>
			 <select name="cardtypes" id="cardtypes" required>
						<option disabled selected>Choose a Card type</option>
						<option value="Visa Card">Visa Card</option>
						<option value="Rupay Card">Rupay Card</option>
						<option value="Master Card">Master Card</option>
						<option value="Discover Card">Discover Card</option>
					</select> <br />

			<label for="cardusername"><strong>Card User Name</strong></label> <input
				type="text" name="cardusername"
				 id="cardusername"
				placeholder="Username" pattern="[a-z]{8,30}" required autofocus>
			
				<br>
			
			<label for="ccn"><strong>Credit Card Number:</strong></label>
<input name="ccn" type="tel" inputmode="numeric" pattern="[0-9\s]{13,16}" autocomplete="cc-number"
 maxlength="19" placeholder="xxxx xxxx xxxx xxxx">
 <br>
			<em> Hint : *Card number must be 13-16 digits *numeric</em>
			<br>
			
				
				<label for="expirydate"><strong>Card Expiry Date </strong> </label>
				 <input name='expirydate' id='expirydate' type='date'
						value='2021-05-24' min='2021-05-24'  required>
							&nbsp;	
						<label for="cvv"><strong>Cvv</strong></label> 
		<input
				type="number" name="cvv"
				 id="cvv"
				placeholder="123" pattern="[0-9]{3,4}" required autofocus>
			
				<br>	
					<em> Note : Card Expiry Date should be atleast today!</em>
					<br>
				
				<label for="amount"><strong>Amount</strong></label> 
		<input
				type="number" name="amount"
				 id="amount"
				placeholder="5,00,000" pattern="[0-9]{,7}" required autofocus>
			
				<br>	
					<em> Note : Online Payment applicable to 10,00000!</em>
				<br>
				<label for="purpose"><strong>Purpose Of Transaction</strong></label> <input
				type="text" name="purpose"
				 id="purpose"
				placeholder="eg:Decoration amount paid"  autofocus>
				<br>
				
			<br><br>
			<button type="submit" class="btn btn-primary">Submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
		</form>


</main>
</body>
</html>