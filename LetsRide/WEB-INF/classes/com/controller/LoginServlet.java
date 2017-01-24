package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.data.UserDB;
import com.domain.Admin;
import com.domain.Doubt;
import com.domain.Notification;
import com.domain.User;
import com.mail.MailUtilGmail;
import com.services.AdminService;
import com.services.LoginService;
import com.services.ObserveNotif;
import com.services.iAdminConsole;
import com.services.iObserver;
import javax.mail.MessagingException;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");
        //System.out.println("1-"+n+" - 2 = "+p);
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", n);  
  
        LoginService loginService=new LoginService();
        User user=new User();
        user=loginService.validate(n,p);
        
        System.out.println("FisrtName"+user.getFirstname());
        System.out.println("Role"+user.getRole());
       try{
        	
        if(user.getRole().equals("T")){   
        	session.setAttribute("name", user); 
        	iObserver countNotifications=new ObserveNotif();
        	ArrayList<Notification> counting=new ArrayList<Notification>();
        	counting=countNotifications.notification(user.getFirstname());
        	int count=counting.size();
        	request.setAttribute("count", count);
        	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            rd.forward(request,response);    
        }   
        else if(user.getRole().equals("D")){
        	session.setAttribute("name", user); 
        	RequestDispatcher rd=request.getRequestDispatcher("welcomeDriver.jsp");    
            rd.forward(request,response); 
        }
        else if(user.getRole().equals("A")){
        	ArrayList<Doubt> doubtlist = new ArrayList<Doubt>();
                    doubtlist = UserDB.selectQueries();
                    request.setAttribute("doubtlist", doubtlist);
                    String url="/Welcomeadmin.jsp";
        	RequestDispatcher rd=request.getRequestDispatcher(url);    
            rd.forward(request,response); 
        }
        else{    
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);    
        }    
        }
       catch (Exception e) {  
    	   // e.printStackTrace();
            System.out.println(e);
            //out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);
        	
        }
      //  out.close();
    
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        //Look at this piece of code everytime you run
        
        int id=8;
        String firstname=request.getParameter("firstname");    
        String lastname=request.getParameter("lastname");  
        String email=request.getParameter("email");    
        String sex=request.getParameter("sex"); 
        String password=request.getParameter("userpass"); 
        String confirmPassword=request.getParameter("confirmpass");
        if(password.equals(confirmPassword))
        {
        String phone=request.getParameter("phone"); 
        String age=request.getParameter("age");    
        String address=request.getParameter("address"); 
        String city=request.getParameter("city");    
        String zip=request.getParameter("zip"); 
        String defaultRole=request.getParameter("role");
        
        User user=new User();
        
        user.setId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(Long.parseLong(phone));
        user.setAge(Integer.parseInt(age));
        user.setSex(sex);
        user.setAddress(address);
        user.setCity(city);
        user.setZip(Long.parseLong(zip));
        user.setRole(defaultRole);
        
        
        LoginService loginService=new LoginService();
        boolean userInserted=loginService.registerUser(user);
        if(userInserted)
        {
        	out.print("<p style=\"color:red\">User successfully registered! You can login now!</p>");
                String to = user.getEmail();
                String from = "mannu610@gmail.com";
                String subject = "Welcome to our email list";
                String body = "Dear " + user.getFirstname()
                                + ",\n\n"  + "Thanks for joining our email list. "
                                 + "We'll make sure to send "
                                  + "you announcements about new products "
                                    + "and promotions.\n"
                                     + "Have a great day\n\n"
                                       + "Thanks & Regards,\n"+
                                         "Charishma Reddy.\n";
                boolean isBodyHTML = false;
                 try {
                           MailUtilGmail.sendMail(to, from, subject, body,isBodyHTML);
                       } catch (MessagingException ex) {
                           String errorMessage= "ERROR: Unable to send email. "
                                   + "Check Tomcat logs for details.<br>"
                                   + "NOTE: You may need to configure your system "
                                   + "as described in chapter 14.<br>"
                                   + "ERROR MESSAGE: " + ex.getMessage();
                           request.setAttribute("errorMessage", errorMessage);
                           this.log("Unable to send email. \n" + "Here is the email you tried to send: \n" + "=====================================\n" 
                                             + "TO: " + user.getEmail() + "\n"
                                             + "FROM: " + from + "\n"
                                             + "SUBJECT: " + subject + "\n\n"
                                             + body + "\n\n");
                       }
        	RequestDispatcher rd=request.getRequestDispatcher("registerSuccess.jsp");
        	rd.forward(request, response);
        }
        
        }
        else
        {
        	out.print("<p style=\"color:red\">Passwords do not match!</p>");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        }
  
        out.close();    
	}


}
