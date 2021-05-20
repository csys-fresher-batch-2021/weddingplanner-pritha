<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-booking</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
  <h1><strong>BOOKING</strong>></h1>
        <br><br/>
    <form action="BookingServlet">
            <label for="weddingdate"><strong>Select Your Wedding Date</strong>> </label>
                <input name='wdate' id='wdate' type='date' value='2021-05-21' min='2021-05-21' max='2022-05-21'required>
                      <ul>
                          <li>
                              <em>
                                  Important
                                  <br></br>
                                  Date should be between 2021-05-21 and 2022-05-21
                                  <br></br>
                                 </em>>
                          </li>
                      </ul>
                      <br> <label for="weddingtime"><strong>Select your pickup Time</strong>></label>
                      <input name='wtime' id='wtime' type="time"value="04:00:00" min="04:00:00" max="16:00:00" required>
                      <br><br/>
                      <ul>
                            <li>
                                <em>
                                    Important
                                    <br></br>
                                    Time should be between 4 AM to 4 PM
                                    <br></br>
                                   </em>>
                            </li>
                        </ul>
                        <br/>
                 <label><strong>Enter Your Wedding Location:</strong>></label>
                    <input type="text" name="wloc" id="wloc" placeholder="Enter your wedding location"  required> 
                    <br/><br/>
                    <input type="submit">

    </form>
</main>
</body>
</html>