<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact Info</title>
</head>
<body>
	<h1 style="text-align: center">Message has been Successfully
		Registered!</h1>
	<%
String name = request.getAttribute("name").toString();
String email = request.getAttribute("email").toString();
String subject = request.getAttribute("subject").toString();
String message = request.getAttribute("message").toString();


 out.println("<h2>Please verify the details</h2>"); 
 %>
	<table border="1"
		style="width: 80%; margin-left: auto; margin-right: auto;">
		<tr>
			<td><b>Name</b></td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td><b>Email Id</b></td>
			<td><%= email %></td>
		</tr>
		<tr>
			<td><b>Subject</b></td>
			<td><%= subject %></td>
		</tr>
		<tr>
			<td><b>Message</b></td>
			<td><%= message %></td>
		</tr>
		
	</table>
</body>
</html>