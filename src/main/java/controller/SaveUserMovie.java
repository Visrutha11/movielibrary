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
import dto.User;
@WebServlet("/saveusermovie")
public class SaveUserMovie extends HttpServlet 
{
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
                int id=Integer.parseInt(req.getParameter("id"));
                dao dao=new dao();
                HttpSession session =req.getSession();
                String username =(String) session.getAttribute("username");
                
                
               	try {
               	 if(username!=null)
                 {
                 
						Movie m=dao.findmovieByid(id);
						String mail=(String) session.getAttribute("usermail");
						User u=dao.findUserByEmail(mail);
						
						session.setAttribute("moviePrice",m.getMovieprice());
						session.setAttribute("movieid",m.getMovieid());
						RequestDispatcher dispatcher=req.getRequestDispatcher("payments.jsp");
					    dispatcher.include(req,resp);
				}
               	 else
               	 {
               	   req.setAttribute("mes", "access denied");
               	   RequestDispatcher dispatcher=req.getRequestDispatcher("ulogin.jsp");
               	   dispatcher.include(req, resp);
               	}	
               	}
                	catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
               	}
        }

