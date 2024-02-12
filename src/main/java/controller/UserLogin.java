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
import dto.User;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet 
{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
      {
    	String email=req.getParameter("userEmail");
    	String password=req.getParameter("userPassword");
         dao dao=new dao();
         try {
			User user=dao.findUserByEmail(email);
			
			if(user!=null)
			{
				if(user.getUserPassword().equals(password))
				{
					if(user.getUserEmail().equals(email))
					{
						HttpSession session=req.getSession();
						session.setAttribute("username",user.getUserName());
						session.setAttribute("userid",user.getUserId());
						session.setAttribute("usermail",user.getUserEmail());
						req.setAttribute("movies",dao.getAllmovies());
						RequestDispatcher dispatcher=req.getRequestDispatcher("userhome.jsp");
						dispatcher.include(req, resp);
					}
					else
					{
						req.setAttribute("message", "password is wrong");
						RequestDispatcher dispatcher=req.getRequestDispatcher("ulogin.jsp");
						dispatcher.include(req, resp);
					}
				}
			}
		} 
            catch (ClassNotFoundException e) {e.printStackTrace();}
            catch (SQLException e) 
           {
		      req.setAttribute("message", "enter valid credinilas");
		      RequestDispatcher dispatcher=req.getRequestDispatcher("ulogin.jsp");
		     dispatcher.include(req, resp);
			
		}
         
         
      }
}
