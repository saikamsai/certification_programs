<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/FlightList.jsp"></portlet:param>
</portlet:renderURL>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<p align="center"
		style="color: Blue; font-size: 25px; font-weight: bold">Payment
		Done Successful</p>
	<br></br>

<p align="center"
		style="color: black; font-size: 20px; font-weight: bold">Flight
		Details</p>

		<jsp:include page="FlightList.jsp" />


	<p align="center"
		style="color: black; font-size: 20px; font-weight: bold">Passenger
		Details</p>

	<%
	String name = request.getParameter("name");
	String Age = request.getParameter("Age");
	String Gender = request.getParameter("Gender");
	String PassportNo = request.getParameter("pass");
	String MobileNo = request.getParameter("phone");
	%>


	<TABLE align="center" BORDER="1">
		<tr>
			<th>Name <br> <br></th>
			<th>Age <br> <br></th>
			<th>Gender<br> <br></th>
			<th>PassportNo<br> <br></th>
			<th>MobileNo<br> <br></th>
		</tr>
		<tr>
			<%

			%>
			<td>
				<%
				out.print(name);
				%>
			</td>
			<td>
				<%
				out.print(Age);
				%>
			</td>
			<td>
				<%
				out.print(Gender);
				%>
			</td>
			<td>
				<%
				out.print(PassportNo);
				%>
			</td>
			<td>
				<%
				out.print(MobileNo);
				%>
			</td>


		</tr>

	</TABLE>
	
</html>


