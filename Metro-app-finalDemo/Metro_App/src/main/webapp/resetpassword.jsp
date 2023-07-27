<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>

	<%
	String uname = request.getParameter("username");
	String password = request.getParameter("newpassword");
	String confirmPassword = request.getParameter("confirmpassword");
	System.out.println(uname);
	System.out.println(password);
	System.out.println(confirmPassword);
	


	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metrostore", "root", "metro@2411");
		PreparedStatement preparedStatement = connection.prepareStatement("update users set password = ? where uname = ? ");
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, uname);
		System.out.println(uname);
		System.out.println(password);

		int i = preparedStatement.executeUpdate();
		if (i > 0) {

			response.sendRedirect("success.jsp");
		} else {

			response.sendRedirect("index.html");
		}
	} catch (Exception e) {

		throw new ClassNotFoundException();
	}
	%>

</body>
</html>