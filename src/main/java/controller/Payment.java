package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import dto.Movie;
import dto.User;

public class Payment extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
             double amount =Double.parseDouble(req.getParameter("amount"));
             HttpSession session=req.getSession();
             dao dao=new dao();
             try {
				Movie m=dao.findmovieByid((int) session.getAttribute("movieid"));
				User u=dao.findUserByEmail((String) session.getAttribute("usermail"));
	              if(m.getMovieprice()==amount)
	              {
	            	  dao.saveUserMovie(u .getUserId(), u.getUserName(),m.getMovieid(),m.getMoviename());
	            	  req.setAttribute("movies", dao.getAllmovies());
	            	  RequestDispatcher dispatcher=req.getRequestDispatcher("userhome.jsp");
	            	  dispatcher.include(req, resp);
	              }
	              else
	              {
	            	  RequestDispatcher dispatcher=req.getRequestDispatcher("payment.jsp");
	            	  dispatcher.include(req,resp);
	              }
			  } 
             catch (ClassNotFoundException | SQLException e) 
             {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } 
             
             
             
             
             
             
    }
}
