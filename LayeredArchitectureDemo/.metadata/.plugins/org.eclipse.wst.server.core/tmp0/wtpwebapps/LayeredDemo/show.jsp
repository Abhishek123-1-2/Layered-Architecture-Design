<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Laptop List</h1>
	<table border="1">
		<tr>
			<th>Laptop ID</th>
			<th>Make</th>
			<th>Cost</th>
		</tr>
		<%
		List<in.mindcraft.pojos.Laptop> laptops = (List<in.mindcraft.pojos.Laptop>) request.getAttribute("laptops");
		for (int i = 0; i < laptops.size(); i++) {
			in.mindcraft.pojos.Laptop laptop = laptops.get(i);
		%>
		<tr>
			<td><%=laptop.getLid()%></td>
			<td><%=laptop.getMake()%></td>
			<td><%=laptop.getCost()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>