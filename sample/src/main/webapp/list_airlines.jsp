<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Airlines</title>
</head>
<body>
	<br>
	<a href="information.jsp"><a href="information.jsp">
			<p align="left"
				style="color: black; font-size: 25px; font-weight: bold">Go Back
	</a></a>
	</p>
	<br>
	<br>
	<p align="center"
		style="color: black; font-size: 25px; font-weight: bold">List of
		Airlines</p>
	<%
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/flyaway", "root", "23@Swetha");
	Statement statement = connection.createStatement();
	ResultSet resultset = statement.executeQuery("select name,code,fleetsize,hub,type from flights");
	%>
	<TABLE align="center" BORDER="1">
		<TR>
			<TH>Name</TH>
			<TH>Code</TH>
			<TH>Fleet Size</TH>
			<TH>Hub</TH>
			<TH>Type</TH>
		</TR>
		<%
		while (resultset.next()) {
		%>
		<TR>
			<TD><%=resultset.getString(1)%></td>
			<TD><%=resultset.getString(2)%></td>
			<TD><%=resultset.getString(3)%></td>
			<TD><%=resultset.getString(4)%></td>
			<TD><%=resultset.getString(5)%></td>
		</TR>
		<%
		}
		%>
	</TABLE>

</body>
</html>