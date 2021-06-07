<%@page import="in.pritha.model.WeddingStyle"%>
<%@page import="java.util.List"%>
<%@page import="in.pritha.service.WeddingStylesService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-home2</title>
<style>
    #heading { color: #2E8B57; }
  </style>
  <%
String loggedInUserName = (String)session.getAttribute("VerfiedLoggedInUser");
String role = (String)session.getAttribute("Role");
%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br>
	<h3 id="heading">Wedding Styles</h3>
	<br>
	<table class="table table-bordered">
	<caption> Wedding styles with Packages </caption>
	<thead>
	<tr><th scope="col">S.no</th><th scope="col">Image</th><th scope="col">Wedding Styles</th><th scope="col">Package(Rs)</th></tr>
	</thead>
	<tbody>
	<%List<WeddingStyle> weddingstyle = WeddingStylesService.getWeddingStylesWithImage();
	int i=0;
	for(WeddingStyle wedding : weddingstyle){
		i++;
 %>
 <tr>
 <td><%=i%></td>
 <td>
 <img src="assets/img/<%=wedding.getImage()%>"width="400" height="200" >
 </td>
 <td><%=wedding.getWeddingStyles() %></td>
 <td><%=wedding.getPackages() %></td>
 </tr>
 <%} %>
	
	
</tbody>
</table>
<% if(loggedInUserName =="gracewed" && role == "admin"){ %>
<a href="addweddingstyles.jsp">Add Wedding Style </a>	
<%} %>	
</main>
</body>
</html>