<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-otp</title>
<style>
 width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border-radius: 25px;
</style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage!=null){
		out.println("<font colour =red>"+errorMessage+"</font>");
	}
	%>
	
<%
	String otp =(String) session.getAttribute("OTP");
	if(otp!=null) {
	%>
	<br><br>
	<em>OTP for Your transaction is : <%=otp %></em>
	<br>
	<em>* Valid for 5 minutes *</em>
	<%
	}
	%>
<form action="CheckOtpServlet">
	
	<div class="d-flex justify-content-center align-items-center container">
    <div class="card py-5 px-3">
        <h5 class="m-0" class="text-danger">Payment Verification</h5><span class="mobile-text"></span><span class="font-weight-bold text-danger cursor">Enter Your Code</span>
        <div class="d-flex flex-row mt-5"><input type="text" name="1" class="form-control"  autofocus=""><input type="text" name="2"class="form-control"><input type="text" name="3" class="form-control"><input type="text" name="4"class="form-control"></div>
        
        <div class="text-center mt-5"><span class="d-block mobile-text">Don't receive the code?</span></div>
   		<span style="margin-left: 45%"><a href="javascript:location.reload(true)">Resend OTP</a></span>
    </div>
</div>
<br><br>
<button type="submit" class="btn btn-primary" style="margin-left: 40%">Submit</button>
			&nbsp; &nbsp;
			
			<button type="reset" class="btn btn-secondary" style="margin-left: 5%">Reset</button>
			&nbsp; &nbsp;
			

</form>
</main>
</body>
</html>