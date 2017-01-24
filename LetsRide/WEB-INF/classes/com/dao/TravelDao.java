package com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.domain.Ride;
import com.domain.Travel;
import com.domain.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class TravelDao {

	public static boolean postTravel(Travel travel)
	{
		Connection conn;
		Statement st = null;
		int rs,maxTravelId = 0;
		PreparedStatement pst = null;
		PreparedStatement pstTime = null;
		ResultSet maxId;
		try 
		{ 		
		   Connect connect=new Connect();
		   conn=connect.initiateConnction();	
		    String sql="select max(id) from travel";
		    try{
		    	st = (Statement) conn.createStatement();
            maxId=(ResultSet) st.executeQuery(sql);
            while(maxId.next())
            {
            	travel.setId(maxId.getInt(1)+1);
            }
            System.out.println("max id fetched="+travel.getId());
		    }catch (Exception e)
		    {
		    	System.out.println("Inside catch of max Id");
		    }
		   pst = conn.prepareStatement("insert into travel values (?,?,?,?,?,?,?,?)");
		   
		   
		   pst.setInt(1, travel.getId());  
           pst.setString(2, travel.getSource()); 
           pst.setString(3, travel.getDestination());
           pst.setLong(4, travel.getDistance());
           pst.setInt(5, travel.getPrice());
           pst.setInt(6, travel.getUserid());
           pst.setInt(7, travel.getCapacity());
           pst.setDate(8, new java.sql.Date(travel.getDate().getTime()));
           
           
           rs = pst.executeUpdate(); 
           
           String maxtime="select max(id) from traveltime";
		    try{
		    	st = (Statement) conn.createStatement();
           maxId=(ResultSet) st.executeQuery(sql);
           while(maxId.next())
           {
           	maxTravelId=maxId.getInt(1)+1;
           	System.out.println("max travel ID="+maxTravelId);
           }
           System.out.println("max travel ID outside while="+maxTravelId);
            
		    }catch (Exception e)
		    {
		    	System.out.println("Inside catch of max Id for traveltime");
		    }
           
           
           pstTime=conn.prepareStatement("insert into traveltime values (?,?,?,?)");
           pstTime.setInt(1, maxTravelId);
           pstTime.setInt(2, travel.getId());            
           pstTime.setInt(3, travel.getHour());
           pstTime.setInt(4, travel.getMinute());
        
           
           rs = pstTime.executeUpdate(); 
           
		}catch (Exception e) {  
            System.out.println(e);  
        } finally {  
               if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            
        }  
		
		return true;
	}

	public static int fetchUserId(String firstname) {
		// TODO Auto-generated method stub
		java.sql.Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
		System.out.println("hey inside try"+firstname);
		String query = "select * from users where firstname='" + firstname + "'";
		 
        System.out.println("query " + query);
        
        try{
        System.out.println("inside try");
        st = conn.createStatement();
        java.sql.ResultSet rs = st.executeQuery(query);
        System.out.println("after query execution");
        
        while (rs.next()) {
        	System.out.println("yes");
           int userid=Integer.parseInt(rs.getString(1)); 
           return userid;

          
        }
        
        conn.close();
        System.out.println("Disconnected!");
        
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
      return 0;
	}
	
	public static Ride fetchFromMyRides(int travelid)
	{
		
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        int userid = 1;
        int driverid = 1;
        User user=new User();
        Ride ride=new Ride();
 
            String query = "select * from myrides where travelid='"+travelid+"'";
            
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for travel id");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(query);
            
 
            while (rs.next()) {
            	
            	
            	ride.setId(rs.getInt(2));
            	ride.setDriverid(rs.getInt(1));
            	ride.setTravellerid(rs.getInt(3));
            	
            	
			
             }
            System.out.println("travelDao:fetchFromMyRides="+ride.getDriverid());
              return ride;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return null;
		
	}
	
	
	public static int driverId(int travelid)
	{
		
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        int userid = 1;
        int driverid = 1;
        User user=new User();
        Ride ride=new Ride();
 
            
            String query2 = "select userid from travel where travelid='"+travelid+"'";
           
            
            try{
            	System.out.println("Executing query in searchDao for driver ID");
            
            Statement st1 = (Statement) conn.createStatement();
            ResultSet rs1 = (ResultSet) st1.executeQuery(query2);
            
 
            while (rs1.next()) {
            	
            	
            	driverid=rs1.getInt(1);
            
            	
            	
			
             }
        
            System.out.println("travelDao:fetchFromMyRides="+driverid);
              return driverid;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
			return driverid;
            
            
            
          
		
	}


	public static void deleteMyRides(int travelid) {
		// TODO Auto-generated method stub
		Connection conn;
		Connect connect=new Connect();
		conn=connect.initiateConnction();
		Ride ride=new Ride();
		ride=TravelDao.fetchFromMyRides(travelid);
		//For notification purpose:
		try {
			PreparedStatement pst=conn.prepareStatement("insert into notification values (?,?,?,?,?)");
			pst.setInt(1, ride.getTravellerid());
			pst.setInt(2, ride.getDriverid());
			pst.setString(3, "delete");
			pst.setInt(4, travelid);
			pst.setString(5, "myrides");
			int rowsFetched=pst.executeUpdate();		
			PreparedStatement pst1=conn.prepareStatement("delete from myrides where travelid=?");
			pst1.setInt(1, travelid);
			
			int rowsFetched1=pst1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void deleteDriverPost(int travelid) {
		// TODO Auto-generated method stub
		Connection conn;
		Connect connect=new Connect();
		conn=connect.initiateConnction();
		Ride ride=new Ride();
		ride=TravelDao.fetchFromMyRides(travelid);
		int driverId=driverId(travelid);
		System.out.println("Ride fetched from fetchmyrides="+ride.getDriverid());
		System.out.println("Ride fetched from fetchmyrides traveller id="+ride.getTravellerid());
		//For notification purpose:
		try {
			//Inserting into notification table
			PreparedStatement pst=conn.prepareStatement("insert into notification values (?,?,?,?,?)");
			pst.setInt(1, ride.getTravellerid());
			pst.setInt(2, driverId);
			pst.setString(3, "delete");	
			pst.setInt(4,  travelid);
			pst.setString(5, "travel");
			System.out.println("Executing the delete driver query");
			int rowsFetched=pst.executeUpdate();	
			System.out.println("travel id is="+travelid);
			PreparedStatement pst2=conn.prepareStatement("delete from myrides where travelid=?");
			pst2.setInt(1, travelid);
			int rowsFetched2=pst2.executeUpdate();
			
			PreparedStatement pst1=conn.prepareStatement("delete from travel where id=?");
			pst1.setInt(1, travelid);
			
			int rowsFetched1=pst1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
