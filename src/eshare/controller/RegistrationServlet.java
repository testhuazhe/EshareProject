package eshare.controller;

import eshare.dao.*;
import eshare.model.*;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        
        registrationDao = new registrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		boolean bResult;
		
		//All parameter get here.
	    String InputhashTag = request.getParameter("hashtag");
		//If it is string then trim all.
        InputhashTag = InputhashTag.trim();
        
        int iLength = InputhashTag.length();

	    bResult = registrationDao.IsPresent(InputhashTag);
		
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("register.jsp");
			 Dispatch.forward(request, response);       	 
		}
		else
		{
			//Add this new hashtag to database.
			Registration NewUser = new Registration();
			
			//here all set field.
			//NewHashtag.setHtName(InputhashTag);
			//NewHashtag.setCreationDate(new Date());
			
			//After all setfield. insert into Database.
			//registrationDao.InsertHashTag(NewUser);
			
			//String InputhashTag = request.getParameter("hashtag");
			//request.setAttribute("hashtag", InputhashTag);
			request.setAttribute("error", "");
			request.setAttribute("NewUser", NewUser);
			RequestDispatcher Dispatch = request.getRequestDispatcher("home.jsp");
			Dispatch.forward(request, response);  
			
		}
	     
        return;
   }
	
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private registrationDAO registrationDao;
	 
}
