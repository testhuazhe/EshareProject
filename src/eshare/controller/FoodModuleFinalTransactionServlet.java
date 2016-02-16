package eshare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.foodModuleFinalTransactionDAO;
import eshare.model.food;

public class FoodModuleFinalTransactionServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	foodModuleFinalTransactionDAO trans = null;
	int peopleNeeded = 0;	//to record how many room left.
	String msg = "error";	//error message if there is no room 
	food f = null;			//food object
	
	public void init(){
		trans = new foodModuleFinalTransactionDAO();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String foodType = request.getParameter("foodType");
		peopleNeeded = trans.checkAvailable(foodType);
		System.out.println(foodType);
		//there is no more room.
		if(peopleNeeded == 0){
			//dispatch back to main view.
			//and display error message.
			request.setAttribute("error", msg);
			request.getRequestDispatcher("/FoodModuleViewServlet").forward(request, response);
		}
		else{
			//f is food object to store the current food information.
			f = trans.viewSelectedFood(foodType);
			request.setAttribute("food", f);
			request.getRequestDispatcher("/finaltransaction.jsp").forward(request, response);
			
			
		}
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
