<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.pritha.service.WeddingStylesService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	<thead>
	<tr><th>S.no</th><th>Wedding Styles</th><th>Package(Rs)</th></tr>
	</thead>
	<tbody>
	<%-- <% Scriplets---> to write java code%>
	<%= Expression---> to get values of variable %> --%>
	<%
	Map<String, Integer> weddingStylesMap = WeddingStylesService.getWeddingStyles();
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
<a href="addweddingstyles.jsp">Add Wedding Style </a>	

</main>
</body>
</html>