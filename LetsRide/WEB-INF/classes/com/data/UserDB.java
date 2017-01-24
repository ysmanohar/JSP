/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.data.DBUtil;
import java.sql.*;
import com.domain.Doubt;
import com.data.ConnectionPool;
import java.util.ArrayList;
/**
 *
 * @author mannu
 */
public class UserDB {

    public static Boolean checkLogin(String email, String password) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT * FROM UserRegistration WHERE email=?";
        try{
            String pass=null;
        ps=connection.prepareStatement(query);
        ps.setString(1,email) ;
        rs= ps.executeQuery();
        if(rs.next()){
            pass=(rs.getString("hashedpassword"));
          }
        System.out.println(pass);
        if(pass==null||pass.length()==0){
            return false;
        }else{ 
            if(pass.equals(password)){
            return true;
           }else{
                return false;
            }
        }

        } catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static String getpass(String email, String firstname) {
                    ConnectionPool pool = ConnectionPool.getInstance();
                    Connection connection = pool.getConnection();
                    PreparedStatement ps = null;
                    ResultSet rs =null;

                    String query= "SELECT password FROM UserRegistration WHERE email=? and firstname=?";
                    try{
                        String pass=null;
                    ps=connection.prepareStatement(query);
                    ps.setString(1,email) ;
                    ps.setString(2,firstname) ;
                    rs= ps.executeQuery();
                    if(rs.next()){
                        pass=(rs.getString("password"));
                      }
                    System.out.println(pass);
                    if(pass==null||pass.length()==0){
                        return null;
                    }else{ 
                        return pass;
                    }

                    } catch(SQLException e){
                        System.out.println(e);
                        return null;
                    }finally{
                        DBUtil.closeResultSet(rs);
                        DBUtil.closePreparedStatement(ps);
                        pool.freeConnection(connection);
                    }
                }
    

    public static int insertdoubt(Doubt doubt) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "INSERT INTO Doubts (custname,email,phone,doubt,postdate) VALUES (?,?,?,?,?)";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, doubt.getName());
        ps.setString(2, doubt.getEmail());
        ps.setString(3, doubt.getMobile());
        ps.setString(4, doubt.getDoubt());
        ps.setString(5, doubt.getPosted_date());
        
       //ps.setString(4,product.getFlag());
        return ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return(0);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Doubt> selectQueries() {
       ArrayList<Doubt> maillist = new ArrayList<Doubt>();
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Doubts";
          try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Doubt doubt = null;
            while (rs.next()) {
                doubt = new Doubt();
                doubt.setID(rs.getInt("ID"));
                doubt.setName(rs.getString("custname"));
                doubt.setEmail(rs.getString("email"));
                doubt.setMobile(rs.getString("phone"));
                doubt.setDoubt(rs.getString("doubt"));
                doubt.setPosted_date(rs.getString("postdate"));
                //product.setFlag(rs.getString("flag"));
                maillist.add(doubt);
            }
            return maillist;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Doubt selectdoubt(String doubtid) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT * FROM Doubts WHERE ID=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, doubtid);
        rs=ps.executeQuery();
        Doubt doubt=null;
        if(rs.next()){
            doubt= new Doubt();
            doubt.setID(rs.getInt("ID"));
            doubt.setName(rs.getString("custname"));
            doubt.setEmail(rs.getString("email"));
            doubt.setMobile(rs.getString("phone"));
            doubt.setDoubt(rs.getString("doubt"));
            doubt.setPosted_date(rs.getString("postdate"));
        }
        return doubt;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void deletedoubt(String id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "DELETE FROM Doubts WHERE ID=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void sentmail(Doubt doubt,String reply) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "INSERT INTO Sentmail (custname,email,phone,doubt,reply) VALUES (?,?,?,?,?)";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, doubt.getName());
        ps.setString(2, doubt.getEmail());
        ps.setString(3, doubt.getMobile());
        ps.setString(4, doubt.getDoubt());
        ps.setString(5, reply);
           //ps.setString(4,product.getFlag());
        ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Doubt> selectSent() {
        ArrayList<Doubt> sentlist = new ArrayList<Doubt>();
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Sentmail";
          try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Doubt doubt = null;
            while (rs.next()) {
                doubt = new Doubt();
                doubt.setName(rs.getString("custname"));
                doubt.setEmail(rs.getString("email"));
                doubt.setMobile(rs.getString("phone"));
                doubt.setDoubt(rs.getString("doubt"));
                doubt.setReply(rs.getString("reply"));
                //product.setFlag(rs.getString("flag"));
                sentlist.add(doubt);
            }
            return sentlist;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static String getSalt(String Email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT salt FROM UserRegistration WHERE email=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, Email);
        rs=ps.executeQuery();
        String salt= null;
        if(rs.next()){
            salt =rs.getString("salt");
        }
        if(salt== null || salt.length()==0){
            return null;
        }else{
           return salt; 
        }
        
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
    }
    }
}
    
    

