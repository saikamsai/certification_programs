<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p align="center"
		style="color: black; font-size: 20px; font-weight: bold">Enter
		Passenger Details</p>
	</p>
	<center>

		<div
			style="border: 3px solid black; width: 25%; border-radius: 20px; padding: 20px"
			align="center">
			<form action=Confirmation.jsp method=get>

				Name: <input type="text" name="name" required /> <br /> <br />
				Age: <input type="text" name="Age" required /> <br /> <br />
				Gender: <input type="text" name="Gender" required /> <br /> <br />
				PassportNo: <input type="text" name="pass" required /> <br /> <br />
				Mobile: <input type="text" name="phone" required /> <br /> <br />
				<button style="margin-top: 5px">pay now</button>
		</div>
	</center>

</body>
</html>