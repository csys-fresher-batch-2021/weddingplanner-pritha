<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.pritha.service.WeddingStyleDisplay"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-Wedding Styles</title>
<style>
    #heading { color: #2E8B57; }
  </style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">Wedding Styles</h3>
	<br><br/>
	<table class="table table-bordered">
	<caption>Wedding Styles with their Packages</caption>
	<thead>
	<tr><th scope="col">S.no</th>
	<th scope="col">Wedding Styles</th>
	<th scope="col">Package(Rs)</th></tr>
	</thead>
	<tbody>
	<%
	Map<String, Integer> weddingStylesMap = WeddingStyleDisplay.getWeddingStyles();
	int i=0;
	Set<String> keySet = weddingStylesMap.keySet();
	for (String key : keySet) {
		Integer value = weddingStylesMap.get(key);
		i++;
	%>
	<tr>
	<td><%=i %></td>
	<td><%=key %></td>
	<td><%=value %></td>
	</tr>
	<% 
	}
	%>
	
	
	
	
	</tbody>
	</table>

</main>
</body>
</html>