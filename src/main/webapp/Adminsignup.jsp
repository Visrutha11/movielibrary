<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   #nav
   {
        background-color:red;
         text-align:centre;
         wordspacing:250px;   
   }  
#cen
{
   text-align:centre;

}
</style>
</head>
<body>
<div id=cen><h1>ADMIN SIGNUP</h1>
<nav id=nav>
<form action="Adminsignup" method="post">
ADMIN ID       <input type="text" name="adminid"><br>
ADMIN NAME     <input type="text" name="adminname"><br>
ADMIN CONTACT  <input type="text" name="admincontact"><br>
ADMIN MAIL     <input type="text" name="adminmail"><br>
ADMIN PASSWORD <input type="text" name="adminpassword"><br>
<input type="submit"><br></nav>
</div>
</form>
</body>
</html>