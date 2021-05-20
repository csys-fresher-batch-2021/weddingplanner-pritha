<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-booking</title>
<style>
    #heading { color: #2E8B57; } 

</style>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br/>
	<h3 id="heading">Booking</h3>
	<br>
<form  action="BookingServlet" method="get">
<label for="weddingdate"><strong>Enter Your Wedding Date</strong> </label>
                <input type='date'id='wdate' name='wdate' value='2021-05-20' min='2021-05-20' max='2026-05-19'required autofocus>
                      <ul>
                          <li>
                              <em>
                                 Note
                                  <br>
                                  Date should be between 2021-05-19 and 2026-05-19
                          
                                 </em>
                          </li>
                      </ul>
                      <br> <label for="Weddingtime"><strong>Enter Your Wedding Time</strong></label>
                      <input id='wtime' type="time"value="05:00:00" min="04:00:00" max="16:00:00" required autofocus>
                      <br><br/>
                      <ul>
                            <li>
                                <em>
                                  Note
 									<br>
                                    Time should be between 4 AM to 4 PM
                                   </em>
                            </li>
                        </ul>
                        <br/>
                   <label><strong>Enter Your Wedding  location</strong></label>
                    <input type="text" name="wloc" id="wloc" placeholder="Enter your wedding location"  required> 
                   <br/><br>
                   <button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp; 
 </form>                
</main>
</body>
</html>