<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Metro Invoice Application</title>

<link rel="stylesheet" href="./index.css">

</head>
<body>

	<%
	String storeID = (String) request.getSession().getAttribute("StoreId");
	%>

	<h2 style="color: green; text-align: center;">
		Login Successfull...!!! Welcome to Metro store :
		<%=storeID%></h2>

	<section>

		<form action="InvoiceController" method="post">
			<div class="imgcontainer">
				<img src="Metro_logo.png" alt="Metro"
					style="width: 205px; height: 80px;" class="">
			</div>
			<br> <br>
			<table style="width: 70%;">

				<tr>
					<td style="color: red; font-size: 21px;">Invoice Number</td>
					<td><input type="text" placeholder="Enter the Invoice Number"
						name="InvoiceNumber" /></td>
				</tr>

				<tr>
					<td style="color: red; font-size: 21px;">Date
					<td><input type="text" placeholder="Enter the date (optional)"
						name="Date" /></td>
				</tr>

				<tr>
					<td><input type="hidden" name="StoreId" value='<%=storeID%>' /></td>
				</tr>

			</table>
			<br> <br> <input type="submit" value="Download"
				style="color: red; margin-bottom: 45px; font-size: 23px;" />

		</form>
	</section>
	<div style="text-align: center;">
		<a href="passwordchange.jsp"> Click here to reset password</a>
	</div>
	<br>
	<br>
	<div style="text-align: center;">
		<a href="logout.jsp"> Click here to Logout</a>
	</div>
</body>
</html>