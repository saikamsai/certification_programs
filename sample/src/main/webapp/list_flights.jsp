<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
	<br>
	<a href="information.jsp">
		<p align="left"
			style="color: black; font-size: 25px; font-weight: bold">Go Back
		
	</a>
	</p>
	<br>
	<br>
	<%
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/flyaway", "root", "23@Swetha");
	Statement statement = connection.createStatement();
	ResultSet resultset = statement.executeQuery("select * from flights");
	%>
	<p align="center"
		style="color: black; font-size: 25px; font-weight: bold">List of
		Flights</p>
	<TABLE align="center" BORDER="1">
		<TR>
			<TH>Name</TH>
			<TH>Code</TH>
			<TH>Fleet Size</TH>
			<TH>Hub</TH>
			<TH>Type</TH>
			<TH>From</TH>
			<TH>To</TH>
			<TH>Date</TH>
			<TH>Time</TH>
			<TH>Price</TH>
		</TR>
		<%
		while (resultset.next()) {
		%>
		<TR>
			<TD><%=resultset.getString(1)%></td>
			<TD><%=resultset.getString(2)%></TD>
			<TD><%=resultset.getString(3)%></TD>
			<TD><%=resultset.getString(4)%></TD>
			<TD><%=resultset.getString(5)%></TD>
			<TD><%=resultset.getString(6)%></TD>
			<TD><%=resultset.getString(7)%></TD>
			<TD><%=resultset.getString(8)%></TD>
			<TD><%=resultset.getString(9)%></TD>
			<TD><%=resultset.getString(10)%></TD>
		</TR>
		<%
		}
		%>
	</TABLE>

</body>
</html>