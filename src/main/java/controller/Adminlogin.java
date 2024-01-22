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
import dto.Admin;
@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet 
{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	 String adminmail=req.getParameter("adminemail");
        	String adminpassword=req.getParameter("adminpassword"); 
        	  dao dao=new dao();
        	  try {
				     Admin admin=dao.findBymail(adminmail);
				if(admin!=null)
				{
					if(admin.getAdminpassword().equals(adminpassword))
					{
						HttpSession session =req.getSession();
						session.setAttribute("adminname",admin.getAdminname());
						req.setAttribute("movies", dao.getAllmovies());
						RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
						dispatcher.include(req, resp);
					}
					else
					{
						req.setAttribute("message","password is worng");
						RequestDispatcher dispatcher=req.getRequestDispatcher("alogin.jsp");
						dispatcher.include(req, resp);
						
					}
				}
				else
				{
					req.setAttribute("message","email is wrong");
					RequestDispatcher dispatcher=req.getRequestDispatcher("alogin.jsp");
					dispatcher.include(req, resp);
					
				}
        	  }
        	catch(ClassNotFoundException e)
        	  {
        		e.printStackTrace();
        	  }
        	catch (SQLException e) 
        	  {
        		  e.printStackTrace();
        		  
			  }
        
        	 
        	
        }
}
