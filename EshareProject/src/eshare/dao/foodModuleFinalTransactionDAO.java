package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import eshare.model.food;
import eshare.util.DBHandle;

public class foodModuleFinalTransactionDAO {

	String viewSelectedFood = null;
	String checkAvailable = null;
	String reducePeople = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	food f = null;
	int peopleNeeded = 0;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
	
	public food viewSelectedFood(String foodType){
		
		//sql syntax
		viewSelectedFood = "select * from food where foodType = '"+foodType+"'";
		reducePeople = "update food set peopleNeeded = peopleNeeded - 1 where foodType = '"+foodType+"'";
		//get connection 
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(reducePeople);
			rs = stmt.executeQuery(viewSelectedFood);
			
			while(rs.next()){
				f = new food();
				f.setFoodType(rs.getString("foodType"));
				f.setFoodPrice(Integer.parseInt(rs.getString("foodPrice")));
				f.setPeopleNeeded(Integer.parseInt(rs.getString("peopleNeeded")));
				f.setPriceperPerson(Double.parseDouble(rs.getString("priceperPerson")));
				f.setFoodQuantity(rs.getString("foodQuantity"));
				f.setVenue(rs.getString("venue"));
				f.setTimefood(formatter2.parse(rs.getString("timefood")));
				f.setDatefood(formatter1.parse(rs.getString("datefood")));
				f.setPaymentType(rs.getString("paymentType"));
				f.setComments(rs.getString("comments"));
				f.setFoodStatus(Integer.parseInt(rs.getString("foodStatus")));
			}
			
						
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	public int checkAvailable(String foodType){
		
		//sql syntax
		checkAvailable = "select peopleNeeded from food where foodType='"+foodType+"'";
		
		//get connection
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(checkAvailable);
			while(rs.next()){
				peopleNeeded = Integer.parseInt(rs.getString("peopleNeeded"));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return peopleNeeded;
	}
}
