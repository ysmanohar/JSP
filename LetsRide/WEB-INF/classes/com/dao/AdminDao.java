package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.domain.Admin;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class AdminDao {

	public static int getTotalRideCounts() {
		
		Connect connect=new Connect();
		int count=0;
		
		try{
			Connection conn=connect.initiateConnction();
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select count(*) from myrides");
			ResultSet rs=(ResultSet) pst.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			System.out.println("Count after executing admin count myrides query="+count);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		System.out.println("Returning count");
		return count;
	}

	public static ArrayList<Admin> getDetailedRideCounts() {
		Connect connect=new Connect();
		ArrayList<Admin> countStatus=new ArrayList<Admin>();
		int count=0;
		String date = null;
		
		try{
			Connection conn=connect.initiateConnction();
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select date,count(id) from travel group by date;");
			ResultSet rs=(ResultSet) pst.executeQuery();
			while(rs.next())
			{
				Admin admin=new Admin();
				date=rs.getString(1);
				count=rs.getInt(2);
				
				admin.setCount(count);
				admin.setDate(date);
				countStatus.add(admin);
			}
			System.out.println("Count after executing admin dates myrides query="+countStatus.get(0).getDate());
			System.out.println("Count after executing admin count myrides query="+countStatus.get(0).getCount());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		System.out.println("Returning count");
		return countStatus;
	}

}
