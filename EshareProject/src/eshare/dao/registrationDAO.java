package eshare.dao;

import eshare.model.*;
import eshare.util.DBHandle;

import java.sql.*;
import java.util.*;

public class registrationDAO
{

	public void InsertNewUser(Registration RegObj)
	{
	    try 
	    {
	        PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into Registration_Table"
	        		+ "(fname,lname,feedcontent)"
	        		+ " values (?, ?, ?)");
	        
	        //dbStatement.setInt(1, hashTagfeed.getParentFeedID());
	        //dbStatement.setString(2, hashTagfeed.getHashtag());
	        //dbStatement.setString(3, hashTagfeed.getContent());
	        
	        //dbStatement.executeUpdate();

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	}
	
	public registrationDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}

	public boolean IsPresent(String UserName)
	{
	    try 
	    {
	        PreparedStatement dbStatement = DBHanlde.
	                prepareStatement("select * from Registration_Table where Email=?");
	        
	        dbStatement.setString(1, UserName);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	        //If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return false;
	}

private Connection DBHanlde;
}