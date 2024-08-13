<%@page import="java.util.Base64"%>
<%@page import="DTO.Movies"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome user</h2>
<%List<Movies> movies=(List)request.getAttribute("movies"); %>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Category</th>
<th>Rating</th>
<th>Image</th>
<th>Delete</th>
<th>Edit</th>
</tr> 
<%for(Movies movie:movies){ %>
<tr>
<td><%=movie.getMid() %></td>
<td><%=movie.getMname() %></td>
<td><%=movie.getCategory() %></td>
<td><%=movie.getRating() %></td>
<%byte[] byteimage=movie.getImage(); %>
<%String image=new String(Base64.getEncoder().encode(byteimage)); %>
<td><img width="200px" height="200px" src="data:image/jpeg;base64,<%=image%>"></td>
<td><a href="delete?id=<%=movie.getMid() %>">Delete</a></td>
<td><a href="edit?id=<%=movie.getMid() %>">Edit</a></td>
<%} %>
</table>
<a href="addmovie.jsp">ADDMOVIES</a>

</body>
</html>