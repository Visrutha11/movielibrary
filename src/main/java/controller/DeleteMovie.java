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
@WebServlet("/deletemovie")
public class DeleteMovie  extends HttpServlet
{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	dao dao=new dao();
	try {
		
		HttpSession session=req.getSession();
        String adminname=(String)session.getAttribute("adminname");
        if(adminname!=null) 
        {
		dao.deletemovie(id);
		req.setAttribute("movies", dao.getAllmovies());
		RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
		dispatcher.include(req, resp);
	    }
        else
        {
          req.setAttribute("movies","acess denied admin login is required");
          RequestDispatcher dispatcher=req.getRequestDispatcher("alogin.jsp");
          dispatcher.include(req, resp);
        }
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}