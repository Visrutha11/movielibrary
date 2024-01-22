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
import dto.Movie;
@WebServlet("/editmovie")
public class EditMovie extends HttpServlet
{
     @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  	    int id=Integer.parseInt(req.getParameter("id"));
  		dao dao=new dao();
  		try
  		{
  			HttpSession session=req.getSession();
  			String adminname=(String) session.getAttribute("adminname");
  			if(adminname!=null)
  			{
  			Movie m = dao.findmovieByid(id);
  			req.setAttribute("movie", m);
  			RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
  			dispatcher.include(req, resp);
  		} 
  			else
  			{
  		        req.setAttribute("messages","access denied,login required");
  		        RequestDispatcher dispatcher =req.getRequestDispatcher("alogin.jsp");
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

