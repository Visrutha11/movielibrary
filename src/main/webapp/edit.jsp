<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  Movie m =(Movie)request.getAttribute("movie");  %>


<form action="updatemovie" method="post" enctype="multipart/form-data">
Movieid<input type="text" name="movieid" value="<%=m.getMovieid() %>" readonly><br>
Moviename<input type="text" name="moviename" value="<%=m.getMoviename() %>" ><br>
Movieprice<input type="text" name="movieprice" value="<%=m.getMovieprice() %>" ><br>
Movierating<input type="text" name="movierating" value="<%=m.getMovierating() %>" ><br>
Moviegeneric<input type="text" name="moviegeneric" value="<%=m.getMoviegeneric() %>" ><br>
Movielanguage<input type="text" name="movielanguage" value="<%=m.getMovielanguage() %>" ><br>      
movieimage<input type="file" name="movieimage"><br>
<input type="submit">
<% String base64image = new String (Base64.getEncoder().encode(m.getMovieimage())); %>
<img src="data:image/jpeg;base64,<%=base64image %>>"height="150px" width="100px">
</form>
</body>
</html>


