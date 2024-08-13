<%@page import="DTO.Movies"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Movies movie=(Movies)request.getAttribute("moviees"); %>
<form action="updatemovie" method="post">
Id:<input type="text" name="id" readonly value=<%=movie.getMid() %>><br>
Name:<input type="text" name="name" value=<%=movie.getMname() %>><br>
Category:<input type="text" name="category" value=<%=movie.getCategory() %>><br>
Rating:<input type="text" name="rating" value=<%=movie.getRating() %>><br>
<input type="submit">
</form>





</body>
</html>