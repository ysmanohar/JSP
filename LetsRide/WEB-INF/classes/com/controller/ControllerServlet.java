/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.domain.Doubt;
import com.data.UserDB;
import com.mail.MailUtilGmail;
import com.mail.MailUtilLocal;
import com.dao.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author mannu
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
        

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        String message = "";
        
        // get current action
        String action = request.getParameter("action");
        System.out.println("Action"+action);
        if (action == null) {
            action = "home";  // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("home")) {
            url = "/index.html";    // the "products" page
            
        }else if(action.equals("doubt")){
                String name = request.getParameter("userName");
                String email = request.getParameter("userEmail");
                String phone=request.getParameter("userPhone");
                String doubt=request.getParameter("userMsg");
                System.out.println("Doubt"+doubt.length());
                if(doubt==null || doubt.length()==0 || doubt.length()==1){
                    message = " Please enter subject feild";
                }else{
                  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date dateobj = new Date();
                String currentdate=df.format(dateobj);
                
                Doubt query=new Doubt();
                query.setName(name);
                query.setEmail(email);
                query.setMobile(phone);
                query.setDoubt(doubt);
                query.setPosted_date(currentdate);
                    try {
                        UserDB.insertdoubt(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                message=" Your Doubt has been sucessfully posted";
                }
                
                // send email to user
                url="/contact.jsp";
                request.setAttribute("message", message);
                    }
        else if(action.equals("Logout")){
            request.getSession().invalidate();
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            url= "/home.jsp";
        }
        else if(action.equals("sentmails")){
                ArrayList<Doubt> sentlist = new ArrayList<Doubt>();
                    sentlist = UserDB.selectSent();
                    request.setAttribute("sentlist", sentlist);
                    url="/SentMail.jsp";
                    }
        else if(action.equals("reply")){
            String doubtid = (String) request.getParameter("id");
            Doubt doubt = UserDB.selectdoubt(doubtid);
            request.setAttribute("doubt", doubt);
            url= "/Sendreply.jsp";
        }
        else if(action.equals("sendreply")){
            String email = request.getParameter("userEmail");
            String reply = request.getParameter("userMsg");
            String id = request.getParameter("emailid");
            System.out.println(email+","+reply+","+id);
            Doubt doubt = UserDB.selectdoubt(id);
            
            
            url="/Welcomeadmin.jsp";
            String to = email;
            String from = "mannu610@gmail.com";
            String subject = "Reply from Lets Ride";
            String body = "Dear " + doubt.getName()
                    + ",\n\n"  + reply +"\n\n"
                    + "Have a great day\n\n"
                    + "Thanks & Regards,\n"+
                    "Charisma Reddy.\n";
            boolean isBodyHTML = false;
            try {
                MailUtilGmail.sendMail(to, from, subject, body,isBodyHTML);
                UserDB.deletedoubt(id);
                UserDB.sentmail(doubt,reply);
                message =" Your message has been sent";
            } catch (MessagingException ex) {
                String errorMessage= "ERROR: Unable to send email. "
                        + "Check Tomcat logs for details.<br>"
                        + "NOTE: You may need to configure your system "
                        + "as described in chapter 14.<br>"
                        + "ERROR MESSAGE: " + ex.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log("Unable to send email. \n" + "Here is the email you tried to send: \n" + "=====================================\n"
                        + "TO: " + email + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n\n"
                        + body + "\n\n");
            }
            request.setAttribute("message", message);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean checkpast(String indate, String intime) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateobj = new Date();
            String currentdate=df.format(dateobj);
            Date date1=null;
            date1 = df.parse(indate);
            Date date2=null;
            date2 = df.parse(currentdate);
            
            if (date1.compareTo(date2) > 0) {
                System.out.println("Date1"+date1 +"is after Date2"+date2);
                return false;
            }else{
                return true;
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }
}

    
