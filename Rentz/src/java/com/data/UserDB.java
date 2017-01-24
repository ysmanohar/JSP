/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;
import com.Controller.Booking;
import com.Controller.Cars;
import com.Controller.Doubt;
import com.data.DBUtil;
import java.sql.*;
import dao.Users;
import com.data.ConnectionPool;
import java.util.ArrayList;
/**
 *
 * @author mannu
 */
public class UserDB {
    public static int insert(Users user) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "INSERT INTO UserRegistration (firstname,lastname,email,sex,password,phone,age,license,zip,hashedpassword,salt) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getSex());
        ps.setString(5, user.getPassword());
        ps.setString(6, user.getPhone());
        ps.setString(7, user.getAge());
        ps.setString(8, user.getLicenseId());
        ps.setString(9, user.getZip());
        ps.setString(10, user.getHashedpassword());
        ps.setString(11, user.getSalt());
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
    
    public static int insertbooking(Booking book) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "INSERT INTO Bookinginfo (model,indate,intime,outdate,outtime,location,email,amount) VALUES (?,?,?,?,?,?,?,?)";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, book.getModel());
        ps.setString(2, book.getIndate());
        ps.setString(3, book.getIntime());
        ps.setString(4, book.getOutdate());
        ps.setString(5, book.getOuttime());
        ps.setString(6, book.getLocation());
        ps.setString(7, book.getEmail());
        ps.setFloat(8, book.getAmount());
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
    
    public static int update(Users user) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "UPDATE UserRegistration SET firstname=?,lastname=?,sex=?,password=?,phone=?,age=?,license=?,zip=? WHERE email=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(3, user.getSex());
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getPhone());
        ps.setString(6, user.getAge());
        ps.setString(7, user.getLicenseId());
        ps.setString(8, user.getZip());
        ps.setString(9, user.getEmail());
        //ps.setString(3,product.getFlag());
        return ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return(0);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deletebooking(String indate,String intime) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "DELETE FROM Bookinginfo WHERE indate=? AND intime=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, indate);
        ps.setString(2, intime);
        return ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
            return(0);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }  
    
    public static boolean emailexists(String email) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT email FROM UserRegistration WHERE email=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1,email) ;
        rs= ps.executeQuery();
        return rs.next();
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Users selectUser(String email) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT * FROM UserRegistration WHERE email=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, email);
        rs=ps.executeQuery();
        Users user=null;
        if(rs.next()){
            user= new Users();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setAge(rs.getString("age"));
            user.setLicenseId(rs.getString("license"));
            user.setZip(rs.getString("zip"));
        }
        return user;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
        public static ArrayList<Booking> selectBooking(String email) {
        ArrayList<Booking> bookinglist = new ArrayList<Booking>();
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Bookinginfo WHERE email=?";
          try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Booking booking = null;
            while (rs.next()) {
                booking = new Booking();
                booking.setModel(rs.getString("model"));
                booking.setIndate(rs.getString("indate"));
                booking.setIntime(rs.getString("intime"));
                booking.setOutdate(rs.getString("outdate"));
                booking.setOuttime(rs.getString("outtime"));
                booking.setLocation(rs.getString("location"));
                booking.setAmount(rs.getFloat("amount"));
                //product.setFlag(rs.getString("flag"));
                bookinglist.add(booking);
            }
            return bookinglist;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    

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
    
    public static Cars Selectcar(String carcode) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "SELECT * FROM Cardetails WHERE carname=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, carcode);
        rs=ps.executeQuery();
        Cars car=null;
        if(rs.next()){
            car= new Cars();
            car.setCategory(rs.getString("category"));
            car.setSpeed(rs.getString("mspeed"));
            car.setCost(rs.getString("cost"));
        }
        return car;
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

    public static Boolean Checkbooking(Booking checkbooking) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null,ps2 = null;
        ResultSet rs1 = null,rs2 =null;
        String intime = null;
        String outtime = null;
        Boolean key1 = false;
        Boolean key2 = false;
        Boolean key3 = false;
        
        String query1= "SELECT intime FROM Bookinginfo WHERE model=? and location=? and indate=?";
        String query2= "SELECT outtime FROM Bookinginfo WHERE model=? and location=? and outdate=?";
        
        try{
        ps1=connection.prepareStatement(query1);
        ps1.setString(1, checkbooking.getModel());
        ps1.setString(2, checkbooking.getLocation());
        ps1.setString(3, checkbooking.getIndate());
        rs1=ps1.executeQuery();
        if(rs1.next()){
            intime =rs1.getString("intime");
        }
        ps2=connection.prepareStatement(query2);
        ps2.setString(1, checkbooking.getModel());
        ps2.setString(2, checkbooking.getLocation());
        ps2.setString(3, checkbooking.getOutdate());
        rs2=ps2.executeQuery();
        if(rs2.next()){
            outtime =rs2.getString("outtime");
        }
        if(intime==null || intime.length()==0 || outtime ==null || outtime.length()==0){
            return false;
        }else{
        if((Integer.parseInt(intime)< Integer.parseInt(checkbooking.getIntime())) && (Integer.parseInt(outtime)> Integer.parseInt(checkbooking.getIntime()))){
            key1= true;
        }
        if((Integer.parseInt(intime)> Integer.parseInt(checkbooking.getIntime())) && (Integer.parseInt(outtime)< Integer.parseInt(checkbooking.getOuttime()))){
            key2= true;
        }
        if((Integer.parseInt(intime)< Integer.parseInt(checkbooking.getOuttime())) && (Integer.parseInt(outtime)> Integer.parseInt(checkbooking.getOuttime()))){
            key3= true;
        }
        if(key1||key2||key3){
            return true;
        }else{
           return false; 
        }
        }
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closeResultSet(rs2);
            DBUtil.closePreparedStatement(ps2);
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

    public static Integer resetpass(String email, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        String query= "UPDATE UserRegistration SET hashedpassword=? WHERE email=?";
        try{
        ps=connection.prepareStatement(query);
        ps.setString(1, password);
        ps.setString(2, email);
        return ps.executeUpdate();
        
        } catch(SQLException e){
            System.out.println(e);
            return 0;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
    }
    }
}
    
    

