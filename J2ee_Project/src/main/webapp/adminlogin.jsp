<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="adminlogin1" method="post">
Email:<input type="text" name="email"><br>
Password:<input type="text" name="password"><br>
<%String message=(String)request.getAttribute("message") ;%>
<%if(message!=null){%><br>
<h3><%=message %></h3>
<%} %>
<input type="submit">
</form>
</body>
</html>