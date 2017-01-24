package com.dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import com.domain.Travel;
import com.domain.User;
import com.mysql.jdbc.Statement;  
  
public class LoginDao {  
    public static User validate(String name, String pass) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "letsride";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";  
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
  
            User user=new User();
            pst = conn.prepareStatement("select * from users where firstname=? and password=?");  
            pst.setString(1, name);  
            pst.setString(2, pass); 
           
  
            rs = pst.executeQuery(); 
            
            while(rs.next())
            {
                   user.setFirstname(rs.getString(2));
                   user.setLastname(rs.getString(3));
                   user.setRole(rs.getString(12));
            }
            //status = rs.next(); 
            return user; 
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return null;
         
    }

	public static boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        int rs;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "letsride";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";  
        try { 
        	
        	int i=3;
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            
            Statement st=(Statement) conn.createStatement();
            String sql="select max(id) from users";
            ResultSet maxId=st.executeQuery(sql);
            while(maxId.next())
            {
            	user.setId(maxId.getInt(1)+1);
            }
  
            pst = conn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, user.getId());
            pst.setString(2, user.getFirstname());  
            pst.setString(3, user.getLastname()); 
            pst.setString(4, user.getPassword());
            pst.setInt(5, user.getAge());
            pst.setString(6, user.getEmail());
            pst.setLong(7, user.getPhone());
            pst.setString(8, user.getSex());
            pst.setString(9, user.getAddress());
            pst.setString(10, user.getCity());
            pst.setLong(11, user.getZip());
            pst.setString(12, user.getRole());
            
            
            
           
  
            rs = pst.executeUpdate();  
              
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
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

	public static User fetchUser(int driverId) {
		// TODO Auto-generated method stub
		
		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			System.out.println("fetch user method="+driverId);
			pst=conn.prepareStatement("select * from users where id=?");
			pst.setInt(1, driverId);
			rs=pst.executeQuery();
			User user=new User();
			while(rs.next())
			{
				
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
			System.out.println("User fetched method="+user.getFirstname());			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static boolean updateBooking(Travel travel) {
		// TODO Auto-generated method stub
		int driverId=travel.getUserid();
		int capacity=travel.getCapacity();
		java.sql.Statement st;
		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		System.out.println("You are in Update Booking method");
		String query="update travel set capacity='"+capacity+"' where userid='"+driverId+"'";
		System.out.println("query for update capacity="+query);
		
		try{
			st=conn.createStatement();
			int p = st.executeUpdate(query);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public static void updateUser(User user) {
		java.sql.Statement st;
		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		System.out.println("You are in Update User method");
		String query="update users set phone='"+user.getPhone()+"',address='"+user.getAddress()+"',city='"+user.getCity()+"',zip='"+user.getZip()+"' where id='"+user.getId()+"'";
		System.out.println("In DAO for update USer:"+query);
		try{
			st=conn.createStatement();
			int p = st.executeUpdate(query);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void updateMyRides(Travel travel, int userid) {
		// TODO Auto-generated method stub
		
		System.out.println("LoginDAo: updateMyRides="+travel.getId());
		int driverId=travel.getUserid();
		int travelId=travel.getId();
		java.sql.Statement st;
		Connect connect=new Connect();
		Connection conn=connect.initiateConnction();
		System.out.println("You are in UupdateMyRides method");
		try {
			PreparedStatement pst = conn.prepareStatement("insert into myrides values(?,?,?)");
			pst.setInt(1,driverId);
			pst.setInt(2,travelId);
			pst.setInt(3, userid);
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}  
}  