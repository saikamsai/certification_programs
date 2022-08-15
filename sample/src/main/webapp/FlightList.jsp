<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body>
	<br>
	<a href="index.jsp">
		<p align="left"
			style="color: black; font-size: 15px; font-weight: bold">Home
	</a>
	</p>
	<br>
	<br>
	<%
	@SuppressWarnings("unchecked")
	List<String[]> flights = (List<String[]>) session.getAttribute("flights");
	if (flights != null) {
	%>


	<center>
		<table border="1">
			<tr>
				<TH>Name</TH>
				<TH>Code</TH>
				<TH>Fleetsize</TH>
				<TH>Hub</TH>
				<TH>Type</TH>
				<TH>from</TH>
				<TH>To</TH>
				<TH>Date</TH>
				<TH>Time</TH>
				<TH>Price</TH>
				
			</tr>



			<%
			for (String[] flight : flights) {
			%>
			<tr>

				<td><%=flight[0]%></td>
				<td><%=flight[1]%></td>
				<td><%=flight[2]%></td>
				<td><%=flight[3]%></td>
				<td><%=flight[4]%></td>
				<td><%=flight[5]%></td>
				<td><%=flight[6]%></td>
				<td><%=flight[7]%></td>
				<td><%=flight[8]%></td>
				<td><%=flight[9]%></td>

			</tr>
		</table>

	</center>

	<center>
		<br>
		<br>
	</center>
	<%
	}
	%>


	<%
	} else {
	%>
	<p align="center"
		style="color: Red; font-size: 25px; font-weight: bold">No Flights Available to book flight Click on Home!!!
		</p>
	<%
	}
	%>