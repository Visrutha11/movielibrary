package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
@WebServlet("/watchmovie")
public class WatchMovie extends HttpServlet 
{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	dao dao=new dao();
    	   try {
			req.setAttribute("movie", dao.getAllUserMovies((int)session.getAttribute("userid")));
		    RequestDispatcher dispatcher= req.getRequestDispatcher("watchmovie.jsp");
		    dispatcher.include(req, resp);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
    }
}
