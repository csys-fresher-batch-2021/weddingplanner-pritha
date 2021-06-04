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
    
  body {
      background: green;
    }
  
    h1 {
      position: absolute;
      top: 10%;
      left: 20%;
    }
  
    h1 span {
      color: #262626;
      background: #fff;
      padding: 10px 20px;
      display: table-cell;
      box-shadow: inset 0 0 5px
                  rgba(0, 0, 0, 0.3),
                  0 5px 0 #ccc;
      animation: animate 0.5s infinite;
    }
  
    /* Specify the animation keyframes
       to be used to move the letters */
    @keyframes animate {
      0% {
        transform: translateY(0px);
      }
  
      50% {
        transform: translateY(-20px);
      }
  
      100% {
        transform: translateY(0px);
      }
    }
  
    /* Specify a slight delay for
       each of the letters */
    h1 span:nth-child(1) {
      animation-delay: 0.1s;
    }
  
    h1 span:nth-child(2) {
      animation-delay: 0.2s;
    }
  
    h1 span:nth-child(3) {
      animation-delay: 0.3s;
    }
  
    h1 span:nth-child(4) {
      animation-delay: 0.4s;
    }
  
    h1 span:nth-child(5) {
      animation-delay: 0.5s;
    }
  
    h1 span:nth-child(6) {
      animation-delay: 0.6s;
    }
  
    h1 span:nth-child(7) {
      animation-delay: 0.7s;
    }
  
    h1 span:nth-child(8) {
      animation-delay: 0.8s;
    }
  
    h1 span:nth-child(9) {
      animation-delay: 0.9s;
    }
  
    h1 span:nth-child(10) {
      animation-delay: 1s;
    }
  
    h1 span:nth-child(11) {
      animation-delay: 1.1s;
    }
  
    h1 span:nth-child(12) {
      animation-delay: 1.2s;
    }
  
    h1 span:nth-child(13) {
      animation-delay: 1.3s;
    } 
</style>
</head>
<body>
 
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h1><span>E</span>
        <span>N</span>
        <span>T</span>
        <span>E</span>
        <span>R</span>
        <span>Y</span>
        <span>O</span>
        <span>U</span>
        <span>R</span>
        <span>O</span>
        <span>T</span>
        <span>P</span></h1>
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
	
<%
	String otp =(String) session.getAttribute("OTP");
	if(otp!=null) {
	%>
	<br><br>
	<em>OTP for Your transaction is : <%=otp %></em>
	<br>
	<em>* Valid for 2 minutes *</em>
	<%
	}
	%>
	
<form action="CheckOtpServlet">
	
	<div class="d-flex justify-content-center align-items-center container">
    <div class="card py-5 px-3">
        <h5 class="m-0" class="text-danger">Payment Verification</h5><span class="mobile-text"></span><span class="font-weight-bold text-danger cursor">TIME LEFT</span>
        
        <div  > <span id="timer"></span></div>
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
	
<script>	
	let timerOn = true;

function timer(remaining) {
  var m = Math.floor(remaining / 60);
  var s = remaining % 60;
  
  m = m < 10 ? '0' + m : m;
  s = s < 10 ? '0' + s : s;
  document.getElementById('timer').innerHTML = m + ':' + s;
  remaining -= 1;
  
  if(remaining >= 0 && timerOn) {
    setTimeout(function() {
        timer(remaining);
    }, 1000);
    return;
  }

  if(!timerOn) {
	  
    // Do validate stuff here
    return;
  }
  
  // If time out, reload the page to get new otp
  alert('Timeout for otp');
  location.reload();
}

timer(120);

</script>
</form>
</main>
</body>
</html>