package eshare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import eshare.model.food;
import eshare.util.DBHandle;

public class foodModuleViewDAO {
	
	String viewExistingPost = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<food> ls = new ArrayList<food>();
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
	
	
	public ArrayList<food> ViewExistingPost(){
		
		//sql syntax
		viewExistingPost = "select * from food";
		
		//get connection
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(viewExistingPost);
			
			while(rs.next()){
				//assign all of the data from db, into food object
				food f = new food();
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
			
				ls.add(f);
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ls;
	}

}
