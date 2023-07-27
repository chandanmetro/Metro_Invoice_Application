<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please wait until URL visible here
	..............................</title>
</head>
<body>

	<%
	String location = (String) request.getSession().getAttribute("FileLocation");
	String fileName = (String) request.getSession().getAttribute("FileName");
	String filelocation = (String) request.getSession().getAttribute("FileLocation");
	System.out.println("FileName " + fileName);
	System.out.println("filelocation " + filelocation);
	%>

<body>
	Downloading File
	<a href="DownloadFile">Download here!!!</a>
</html>