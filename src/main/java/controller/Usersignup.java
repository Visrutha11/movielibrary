package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
@WebServlet("/usersignup")
public class Usersignup   extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

           	int id = Integer.parseInt(req.getParameter("userId"));
    		String name = req.getParameter("userName");
    		long contact = Long.parseLong(req.getParameter("userContact"));
    		String email = req.getParameter("userEmail");
    		String password = req.getParameter("userPassword");
    		
           	dao dao=new dao();
           
    		
     
           	
           	
           	
           	
           	
    }    }

