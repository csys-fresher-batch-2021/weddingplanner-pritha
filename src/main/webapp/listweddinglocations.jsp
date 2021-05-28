<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-listweddingstyles</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br><br/>
	<h3 id="heading">Wedding Locations</h3>
	<br><br/>
	<table class="table table-bordered">
	<caption> Wedding Locations With Packages
	</caption>
	<thead>
	<tr><th scope="col">S.no</th><th scope="col">Wedding Locations</th><th scope="col">Package(Rs)</th></tr>
	</thead>
	<tbody>
	<%
	Map<String,Integer> weddinglocations = (Map<String,Integer>) request.getAttribute("WEDDING_LOCATIONS");
	if(weddinglocations!=null) {
		int i=0;
		Set<String> keySet = weddinglocations.keySet();
	for (String key : keySet) {
		Integer value = weddinglocations.get(key);
		i++;
	
	%>
	<tr>
	<td><%=i %></td>
	<td><%=key %></td>
	<td><%=value %></td>
	</tr>
	<% 
	}
	}
	
	%>


</tbody>
</table>

</main>
</body>
</html>