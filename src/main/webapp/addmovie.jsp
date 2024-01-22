<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Movie</h2>  
  <form action="savemovie" method="post"enctype="multipart/form-data">
  MOVIE Id<input type="text" name="movieid"><br>  
  MOVIE NAME<input type="text" name="moviename"><br>  
  MOVIE PRICE<input type="text" name="movieprice"><br>  
  MOVIE RATING<input type="text" name="movierating"><br>  
  MOVIE GENERIC<input type="text" name="moviegeneric"><br>  
  MOVIE LANGUAGE<input type="text" name="movielanguage"><br>  
  MOVIE IMAGE<input type="file" name="movieimage"><br>  
  <input type="submit">    
</form>
</body>
</html>