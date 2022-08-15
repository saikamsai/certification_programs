<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<br>
	<a href="information.jsp">Go Back</a>
	<br>
	<br>
	<center>
		<h1>Insert New Flight Details</h1>

		<div
			style="border: 3px solid black; width: 25%; border-radius: 20px; padding: 20px"
			align="center">
			<form action=InsertFlight method=post>
				<label for=name>Name :-</label> <input type="text" name=name id=name required/><br>
				<br> <label for=code>Code :-</label> <input type="text"
					name=code id=code required/><br><br>
					
					<label for=fleetsize>Fleetsize :-</label> <input type="text"
					name=fleetsize id=fleetsize required/><br><br>
					
					<label for=hub>Hub :-</label> <input type="text"
					name=hub id=hub required/><br><br>
					
					<label for=type>Type :-</label> <input type="text"
					name=type id=type required/><br><br>
					
				<label for=from>From :-</label> <input type="text"
					name=from id=from required /><br>
				<br> <label for=to>To :-</label> <input type="text" name=to
					id=to required/><br>
				<br> <label for=departure>Departure :-</label> <input
					type="date" name=departure id=departure required /><br>
				<br> <label for=time>Time :-</label> <input type="time"
					name=time id=time required/><br>
				<br> <label for=price>Price :-</label> <input type="text"
					name=price id=price required /><br>
				<br> <input type=submit value=submit /> <input type=reset />
			</form>
		</div>
	</center>
	<%
	String message = (String) session.getAttribute("message");
	if (message != null) {
	%>
	<p style="color: silver;"><%=message%></p>
	<%
	session.setAttribute("message", null);
	}
	%>
</body>
</html>