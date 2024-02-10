package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;

import dto.Admin;
import dto.Movie;
import dto.User;

public class dao 
{
     public Connection getconnection() throws ClassNotFoundException,SQLException 
     {
             Class.forName("com.mysql.cj.jdbc.Driver");
             return DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary","root","root");
     }
     
     public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException
     {
    	 Connection conn=getconnection();
    	 PreparedStatement pst=conn.prepareStatement("insert into admin values(?,?,?,?,?)");
    	 pst.setInt(1, admin.getAdminid());
    	 pst.setString(2, admin.getAdminname());
    	 pst.setLong(3, admin.getAdmincontact());
    	 pst.setString(4,admin.getAdminemail());
    	 pst.setString(5,admin.getAdminpassword());
    	return pst.executeUpdate(); 
     }
     
     public Admin findBymail(String adminmail) throws SQLException, ClassNotFoundException
     {     
     Connection conn= getconnection();
     PreparedStatement pst=conn.prepareStatement("select * from admin where adminemail=?");
     pst.setString(1, adminmail);
     ResultSet rs=pst.executeQuery();
     Admin admin=new Admin();
     
     while(rs.next()) {
     admin.setAdminid(rs.getInt(1));
     admin.setAdminname(rs.getString(2));
     admin.setAdminemail(rs.getString(4));
     admin.setAdmincontact(rs.getLong(3));
     admin.setAdminpassword(rs.getString(5));
     }
     return admin;
     
     }
     
     public int savemovie(Movie movie) throws ClassNotFoundException, SQLException
     
     {
    	  Connection conn= getconnection();
    	  PreparedStatement pst=conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
    	  pst.setInt(1,movie.getMovieid());
    	  pst.setString(2,movie.getMoviename());
    	  pst.setDouble(3, movie.getMovieprice());
    	  pst.setDouble(4, movie.getMovierating());
    	  pst.setString(5, movie.getMoviegeneric());;
          pst.setString(6, movie.getMovielanguage());    	  
          Blob imageblob=new SerialBlob(movie.getMovieimage());
          pst.setBlob(7, imageblob);
          
          return pst.executeUpdate();       
     }     
     
     public List<Movie>getAllmovies() throws ClassNotFoundException,SQLException
     {
     Connection con =getconnection();
     PreparedStatement pt=con.prepareStatement("select*from movie");
     ResultSet rs=pt.executeQuery();
     List<Movie>movies=new ArrayList<Movie>();
      while (rs.next())
      {
    	  Movie m=new Movie();
    	  m.setMovieid(rs.getInt(1));
    	  m.setMoviename(rs.getString(2));
    	  m.setMovieprice(rs.getDouble(3));
    	  m.setMovierating(rs.getDouble(4));
    	  m.setMoviegeneric(rs.getString(5));
    	  m.setMovielanguage(rs.getString(6));
    	   Blob b=rs.getBlob(7);
    	   byte[] img=b.getBytes(1, (int)b.length());
    	   m.setMovieimage(img);
    	   movies.add(m);
      }
        return movies;   	  
      }        
     public  int deletemovie(int id) throws ClassNotFoundException, SQLException
     {
    	 Connection conn=getconnection();
    	 PreparedStatement pst=conn.prepareStatement("delete from movie where movieid =?");
    	 pst.setInt(1, id);
    	 return pst.executeUpdate();
     }
     
     
     public Movie findmovieByid(int movieid) throws ClassNotFoundException, SQLException 
     {
    	 Connection conn=getconnection();
    	 PreparedStatement pst=conn.prepareStatement("select * from movie where movieid = ? ");
    	 pst.setInt(1, movieid);
    	 ResultSet rs= pst.executeQuery();
    	 rs.next();
    	 Movie m=new Movie();
    	 m.setMovieid(rs.getInt(1));
    	 m.setMoviename(rs.getString(2));
    	 m.setMovieprice(rs.getDouble(3));
    	 m.setMovierating(rs.getDouble(4));
    	 m.setMoviegeneric(rs.getString(5));
    	 m.setMovielanguage(rs.getString(6));
    	 Blob b= rs.getBlob(7);
    	 byte[]img=b.getBytes(1,(int)b.length());
    	 m.setMovieimage(img);
    	 return m;        
     }
     
     public int updateMovie(Movie movie) throws ClassNotFoundException, SQLException 
     { 
     Connection conn=getconnection();
     PreparedStatement pst=conn.prepareStatement("update movie set moviename=?, movieprice=?,movierating=?, moviegeneric=?,movielanguage=?,movieimage=? where movieid=?");
     pst.setInt(7, movie.getMovieid());
     pst.setString(1,movie.getMoviename());
     pst.setDouble(2, movie.getMovieprice());
     pst.setDouble(3, movie.getMovierating());
     pst.setString(4, movie.getMoviegeneric());
     pst.setString(5,movie.getMovielanguage());
     Blob imageBlob =new SerialBlob(movie.getMovieimage());
     pst.setBlob(6, imageBlob);
	 return pst.executeUpdate();      
     }
     public int saveUser(User u) throws ClassNotFoundException,SQLException
     {
    	 Connection con=getconnection();
    	 PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?)");
    	 
    	 pst.setInt(1, u.getUserId());
    	 pst.setString(2,u.getUserName());
    	 pst.setLong(3, u.getUserContact());
    	 pst.setString(4,u.getUserEmail());
    	 pst.setString(5,u.getUserPassword());
    	 return pst.executeUpdate(); 
     }
     public User findUserByEmail(String email) throws ClassNotFoundException,SQLException
     {
    	 Connection con=getconnection();
    	 PreparedStatement pst=con.prepareStatement("select * from User where uMail=?");
    	 pst.setString(1,email);
    	 ResultSet rs=pst.executeQuery();
    	 User u=new User();
    	 rs.next();
    	 u.setUserId(rs.getInt(1));
    	 u.setUserName(rs.getString(2));
    	 u.setUserContact(rs.getLong(3));
    	 u.setUserEmail(rs.getString(4));
    	 u.setUserPassword(rs.getString(5)); 
    	 return u;
     }
     
     public void saveUserMovie(int uid, String uname,int mid,String mname)throws ClassNotFoundException,SQLException
     {    	 
    	 Connection conn=getconnection();
    	 PreparedStatement pst=conn.prepareStatement("inser into user_movie values(?,?,?,?)");
    	 pst.setInt(1, uid);
    	 pst.setString(2, uname);
    	 pst.setInt(2, mid);
    	 pst.setString(4, mname);
		 pst.executeUpdate();
     }
     
     
     public List<Movie>getAllUserMovies(int uid)throws ClassNotFoundException,SQLException
     {
    	 Connection con=getconnection();
    	 PreparedStatement pst=con.prepareStatement("select * from inner joins user_movie");
    			 pst.setInt(1, uid);
    	 ResultSet rs=pst.executeQuery();
    	 List<Movie> movies=new ArrayList<Movie>();
    	 while(rs.next())
    	 {
    		 Movie m=new Movie();
    		 m.setMovieid(rs.getInt(1));
    		 m.setMoviename(rs.getString(2));
    		 Blob b=rs.getBlob(7);
    		 byte[] img=b.getBytes(1, (int)b.length());
    		 m.setMovieimage(img);
    		 movies.add(m); 
    	 }
    	 return movies;
     }
     
     public int deleteUserMovie(int movieid)throws ClassNotFoundException ,SQLException
     {
    	 Connection con=getconnection();
    	 PreparedStatement pst=con.prepareStatement("delete from user_movie where mid=? ");
    	 pst.setInt(1, movieid);
    	 
    	 return pst.executeUpdate();
     }
}