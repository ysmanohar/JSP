package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import com.domain.Travel;
import com.domain.User;
import com.services.SearchService;

public class SearchDao {

	public ArrayList<Travel> searchByName(String pid,String destination) {
		// TODO Auto-generated method stub
		
 
        Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
 
            ArrayList<Travel> al = null;
            ArrayList<Travel> pid_list = new ArrayList<Travel>();
            String query = "select * from travel where source='" + pid + "' and destination='" + destination + "' ";
 
            System.out.println("query " + query);
            
            try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
                //al = new ArrayList();
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
            	//DOUBT: If travel is declared outside while loop, it will always take same travel values.WHY??
            	Travel travel=new Travel();
                travel.setId(Integer.parseInt(rs.getString(1))); 
                travel.setSource(rs.getString(2)); 
                travel.setDestination(rs.getString(3));
                travel.setDistance(Long.parseLong(rs.getString(4)));
                travel.setPrice(Integer.parseInt(rs.getString(5)));
                travel.setUserid(Integer.parseInt(rs.getString(6)));
 
               // System.out.println("al :: " + al);
                pid_list.add(travel);
            }
            //conn.close();
            System.out.println("Disconnected!");
            for(int i=0;i<pid_list.size();i++)
            {
            	System.out.println(pid_list);
            }
            return pid_list;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return null;
 
		
		
	}

	public static Travel fetchBookingDetail(int travelid) {
		// TODO Auto-generated method stub
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
 
            ArrayList<Travel> al = null;
            ArrayList<Travel> pid_list = new ArrayList<Travel>();
            String query = "select * from travel where id='"+travelid+"'";
 
            System.out.println("query " + query);
            
            try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Travel travel=new Travel();
           while (rs.next()) {
                //al = new ArrayList();
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
            	//DOUBT: If travel is declared outside while loop, it will always take same travel values.WHY??
            	
                travel.setId(Integer.parseInt(rs.getString(1))); 
                travel.setSource(rs.getString(2)); 
                travel.setDestination(rs.getString(3));
                travel.setDistance(Long.parseLong(rs.getString(4)));
                travel.setPrice(Integer.parseInt(rs.getString(5)));
                travel.setUserid(Integer.parseInt(rs.getString(6)));
 
               // System.out.println("al :: " + al);
               // pid_list.add(travel);
          }
           
            //conn.close();
            System.out.println("Disconnected!");
           // for(int i=0;i<pid_list.size();i++)
            //{
            	//System.out.println(pid_list);
            //}
            return travel;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return null;
	}

	public static ArrayList<Travel> searchByBooking(int driverId, Date date, String source) {
		// TODO Auto-generated method stub
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        Travel travel=new Travel();
        
        ArrayList<Travel> allBookings = null;
        ArrayList<Travel> travelList = new ArrayList<Travel>();
       // String query = "select * from travel where userid='"+driverId+"' and date='"+date+"'and source='"+source+"'";
        String query = "select * from travel where userid='"+driverId+"' and source='"+source+"'";
        System.out.println("query " + query);
        
        try{
        	st=conn.createStatement();
        	ResultSet rs=st.executeQuery(query);
        	while(rs.next())
        	{
        		travel.setId(Integer.parseInt(rs.getString(1))); 
                travel.setSource(rs.getString(2)); 
                travel.setDestination(rs.getString(3));
                travel.setDistance(Long.parseLong(rs.getString(4)));
                travel.setPrice(Integer.parseInt(rs.getString(5)));
                travel.setUserid(Integer.parseInt(rs.getString(6)));
                travel.setCapacity(Integer.parseInt(rs.getString(7)));
                travel.setDate(rs.getDate(8));
                
                travelList.add(travel);
        	}
        	System.out.println("Search DAO-fetchByBooking list="+travelList);
        	return travelList;
        	
        }catch (Exception e) {
            e.printStackTrace();
        }
		return travelList;
        
        
        
		
	}

	public static User searchBySessionName(String name) {
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        User user=new User();
 
            ArrayList<Travel> al = null;
            ArrayList<Travel> pid_list = new ArrayList<Travel>();
            String query = "select * from users where firstname='"+name+"'";
 
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for user update");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
            	
            	user.setId(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setAge(rs.getInt(5));
				user.setEmail(rs.getString(6));
				user.setPhone(rs.getLong(7));
				user.setSex(rs.getString(8));
				user.setAddress(rs.getString(9));
				user.setCity(rs.getString(10));
				user.setZip(rs.getLong(11));
				user.setRole(rs.getString(12));
			
             }
              System.out.println("User fetched from database in SearchDao for updating purpose is="+user.getEmail());
              return user;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return null;
	}

	public static int fetchUserId(String userName) {
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        int userid = 1;
        User user=new User();
 
            ArrayList<Travel> al = null;
            ArrayList<Travel> pid_list = new ArrayList<Travel>();
            String query = "select id from users where firstname='"+userName+"'";
 
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for user id");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
            	
            	userid=rs.getInt(1);
            	System.out.println("User id fetched in DAO is="+userid);
			
             }
             
              return userid;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return 1;
	}

	

	public int fetchTravelIdMyRide(int userId) {
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        int userid = 1;
        User user=new User();
 
            String query = "select travelid from myrides where travellerid='"+userId+"'";
 
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for travel id");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
            	
            	userid=rs.getInt(1);
            	System.out.println("travel id fetched in DAO is="+userid);
			
             }
             
              return userid;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return 1;
		
	}

	public ArrayList<Travel> fetchTravellerIdMyRide(int userId) {
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        ArrayList<Travel> travelDetails=new ArrayList<Travel>();
        
       
        int userid = 1;
        User user=new User();
        
        	//Get the travel id corresponding to the user from myrides table
           
            String query = " select * from travel where id in (select travelid from myrides where travellerid='"+userId+"')";
 
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for travel id");
            st = conn.createStatement();
        
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
            	 Travel travel=new Travel();
            	System.out.println("printing id of first fetched="+Integer.parseInt(rs.getString(1)));
            	travel.setId(Integer.parseInt(rs.getString(1))); 
                travel.setSource(rs.getString(2)); 
                travel.setDestination(rs.getString(3));
                travel.setDistance(Long.parseLong(rs.getString(4)));
                travel.setPrice(Integer.parseInt(rs.getString(5)));
                travel.setUserid(Integer.parseInt(rs.getString(6)));
                travel.setCapacity(Integer.parseInt(rs.getString(7)));
                travel.setDate(rs.getDate(8));
                
               
            	travelDetails.add(travel);
			
             }
             
              System.out.println("In DAO traveller ID fetched="+travelDetails.size());
              return travelDetails;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return travelDetails;
		
	}
	
	public ArrayList<Travel> fetchDriverIdMyRide(int userId) {
		Statement st;
        Connect connect=new Connect();
        Connection conn=connect.initiateConnction();
        ArrayList<Travel> travelDetails=new ArrayList<Travel>();
        
       
        int userid = 1;
        User user=new User();
        
        	//Get the travel id corresponding to the user from myrides table
           
            String query = " select * from travel where userid='"+userId+"'";
 
            System.out.println("query " + query);
            
            try{
            	System.out.println("Executing query in searchDao for travel id");
            st = conn.createStatement();
        
            ResultSet rs = st.executeQuery(query);
            
 
            while (rs.next()) {
            	 Travel travel=new Travel();
            	System.out.println("printing id of first fetched="+Integer.parseInt(rs.getString(1)));
            	travel.setId(Integer.parseInt(rs.getString(1))); 
                travel.setSource(rs.getString(2)); 
                travel.setDestination(rs.getString(3));
                travel.setDistance(Long.parseLong(rs.getString(4)));
                travel.setPrice(Integer.parseInt(rs.getString(5)));
                travel.setUserid(Integer.parseInt(rs.getString(6)));
                travel.setCapacity(Integer.parseInt(rs.getString(7)));
                travel.setDate(rs.getDate(8));
                
               
            	travelDetails.add(travel);
			
             }
             
              System.out.println("In DAO traveller ID fetched="+travelDetails.size());
              return travelDetails;
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
          return travelDetails;
		
	}

}
