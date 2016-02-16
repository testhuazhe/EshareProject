package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eshare.model.food;
import eshare.util.DBHandle;;

public class foodModulePostDAO {
	
	Connection conn = null;
	String insertNewPost = null;
	public void InsertNewPost(food f){
		
		insertNewPost = "insert into food (foodType,foodPrice,peopleNeeded,priceperPerson"
					+ ",foodQuantity,venue,timefood,datefood,paymentType,comments,foodStatus) values ('"
					+ f.getFoodType()+"','"+f.getFoodPrice()+"','"+f.getPeopleNeeded()+"','"+f.getPriceperPerson()+"','"
					+f.getFoodQuantity()+"','"+f.getVenue()+"','"+f.getTimefood()+"','"+f.getDatefood()+"','"+f.getPaymentType()+"','"
					+f.getComments()+"','"+f.getFoodStatus()+"')";
		//get connection
		conn = DBHandle.getDBHandle();
		
		try {
			//prepare statement
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insertNewPost);
			ResultSet rs = null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
