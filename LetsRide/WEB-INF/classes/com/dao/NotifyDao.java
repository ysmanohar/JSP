package com.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.domain.Action;
import com.domain.Notification;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class NotifyDao {

	public static ArrayList<Notification> fetchByIDNotif(int travellerId) {

		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		java.sql.PreparedStatement pst=null;
		
		try{
			       System.out.println("Traveller Id="+travellerId);
		           pst=conn.prepareStatement("select distinct * from notification where travellerid=?");
		           pst.setInt(1, travellerId);
		           java.sql.ResultSet rs=pst.executeQuery();
		           
		           
		           ArrayList<Notification> notifications=new ArrayList<Notification>();
		           while(rs.next())
		           {
		        	   Notification notif=new Notification();
		        	   notif.setTravellerid(rs.getInt(1));
		        	   notif.setDriverid(rs.getInt(2));
		        	   notif.setAction(rs.getString(3));
		        	   notif.setTravelid(rs.getInt(4));
		        	   notif.setFromTable(rs.getString(5));
		        	   
		        	   notifications.add(notif);
		           }
		           System.out.println("notifications size is="+notifications.size());
		           return notifications;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	return null;
	}
	
	public static ArrayList<Notification> fetchByIDDriverNotif(int travellerId) {
	{
		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		java.sql.PreparedStatement pst=null;
		
		/*try{
			
		           pst=conn.prepareStatement(" select distinct i.firstname,notif.action from users i,notification notif where id in (select travellerid from notification where driverid=?);");
		           pst.setInt(1, travellerId);
		           java.sql.ResultSet rs=pst.executeQuery();
		           
		           
		           ArrayList<Action> notifications=new ArrayList<Action>();
		           while(rs.next())
		           {
		        	   Action action=new Action();
		        	   action.setName(rs.getString(1));
		        	   action.setAction(rs.getString(2));
		        	   notifications.add(action);
		           }
		           System.out.println("notifications size is="+notifications.size());
		           return notifications;
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		try{
		       System.out.println("Traveller Id="+travellerId);
	           pst=conn.prepareStatement("select distinct * from notification where driverid=?");
	           pst.setInt(1, travellerId);
	           java.sql.ResultSet rs=pst.executeQuery();
	           
	           
	           ArrayList<Notification> notifications=new ArrayList<Notification>();
	           while(rs.next())
	           {
	        	   Notification notif=new Notification();
	        	   notif.setTravellerid(rs.getInt(1));
	        	   notif.setDriverid(rs.getInt(2));
	        	   notif.setAction(rs.getString(3));
	        	   notif.setTravelid(rs.getInt(4));
	        	   notif.setFromTable(rs.getString(5));
	        	   
	        	   notifications.add(notif);
	           }
	           System.out.println("notifications size is="+notifications.size());
	           return notifications;
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
return null;
		
		


	}
	
	}

}
