package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import dto.Admin;
@WebServlet("/Adminsignup")
public class SaveAdmin extends HttpServlet
{
     @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
     {
    	int id=Integer.parseInt(req.getParameter("adminid"));
    	String name=req.getParameter("adminname");
    	long contact= Long.parseLong(req.getParameter("admincontact"));
    	String email=req.getParameter("adminmail");
    	String password=req.getParameter("adminpassword");
    	
    	Admin admin=new Admin();
    	admin.setAdminid(id);
    	admin.setAdmincontact(contact);
    	admin.setAdminemail(email);
    	admin.setAdminname(name);
    	admin.setAdminpassword(password);
    	
    	
    	dao dao=new dao();         
    			try { 
				int res=dao.saveAdmin(admin);
				if(res>0)
				{
					RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");
					rd.include(req,resp);
			    }
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("adminsignup.jsp");
					rd.include(req, resp);
				}
         }
				
               catch (ClassNotFoundException e) 
    			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
    	
           catch (SQLException e)
    			{
			// TODO: handle exception
        	   e.printStackTrace();
		        }
         
     }
     }
