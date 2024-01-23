package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.dao;
import dto.Movie;
@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize =5*1024*1024)
public class UpdateMovie extends HttpServlet
{
	@Override     
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
      {
    	  int movieid=Integer.parseInt(req.getParameter("movieid"));
    	  String moviename=req.getParameter("moviename");
    	  double movieprice=Double.parseDouble(req.getParameter("movieprice"));
    	  double movierating=Double.parseDouble(req.getParameter("movierating"));
    	  String moviegeneric=req.getParameter("moviegeneric");
    	  String movielanguage=req.getParameter("movielanguage");
    	  Part imagepart=req.getPart("movieimage");
    	  
    	  Movie movie=new Movie();
    	  movie.setMovieid(movieid);
    	  movie.setMoviename(moviename);
    	  movie.setMovieprice(movieprice);
          movie.setMovierating(movierating);    	  
          movie.setMoviegeneric(moviegeneric);
    	  movie.setMovielanguage(movielanguage);
    	  
    	  
    	  dao dao=new dao();
    	  try {
    	  
    	  if(imagepart.getSize()>0)
    	  {
    		  movie.setMovieimage(imagepart.getInputStream().readAllBytes());
				dao.updateMovie(movie);
				
				req.setAttribute("movie", dao.getAllmovies());
				RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, resp);
				
    	  }
    	  else
    	  {
    		  Movie dbmovie=dao.findmovieByid(movieid);
    		  movie.setMovieimage(dbmovie.getMovieimage());
    		  dao.updateMovie(movie);
    		  
    		  
    		  req.setAttribute("movie", dao.getAllmovies());
    		  RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
    		  dispatcher.include(req, resp);
    	  }
    	  }
    	  
    	   catch (ClassNotFoundException e) 
    	   {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   catch (SQLException e) 
    	   {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   }
    		  
    	  
    	  
    	  
    	  
       
    
}
}