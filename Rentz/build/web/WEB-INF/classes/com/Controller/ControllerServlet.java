/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import static com.Controller.PasswordUtil.hashAndSaltPassword;
import com.data.UserDB;
import com.mail.MailUtilGmail;
import com.mail.MailUtilLocal;
import dao.Users;
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
import java.util.UUID;
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
            
        } else if(action.equals("register")){
            try {
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String Email=request.getParameter("email");
                String Sex=request.getParameter("sex");
                String Password=request.getParameter("userpass");
                String cnfrmpass=request.getParameter("confirmpass");
                String Phone=request.getParameter("phone");
                String Age=request.getParameter("age");
                String License=request.getParameter("license");
                String Zip=request.getParameter("zip");
                if(UserDB.emailexists(Email)){
                    message="*** Please enter unique e-mail address ***";
                    url="/register.jsp";
                }else{
                    if(Password.equals(cnfrmpass)){
                        Users user=new Users();
                        ArrayList<String> passwordlist = new ArrayList<String>();
                        passwordlist = hashAndSaltPassword(Password,Email);
                        System.out.println("salt"+passwordlist.get(0));
                        System.out.println("Hashed"+passwordlist.get(1));
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmail(Email);
                user.setSex(Sex);
                user.setPassword(Password);
                user.setPhone(Phone);
                user.setAge(Age);
                user.setLicenseId(License);
                user.setZip(Zip);
                user.setHashedpassword(passwordlist.get(1));
                user.setSalt(passwordlist.get(0));
                UserDB.insert(user);
                // send email to user
                url="/Login.jsp";
                String to = Email;
                String from = "mannu610@gmail.com";
                String subject = "Welcome to our email list";
                String body = "Dear " + firstName 
                                + ",\n\n"  + "Thanks for joining our email list. "
                                 + "We'll make sure to send "
                                  + "you announcements about new products "
                                    + "and promotions.\n"
                                     + "Have a great day\n\n"
                                       + "Thanks & Regards,\n"+
                                         "Sai Manohar Yerra.\n";
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
                                             + "TO: " + Email + "\n"
                                             + "FROM: " + from + "\n"
                                             + "SUBJECT: " + subject + "\n\n"
                                             + body + "\n\n");
                       }
                 
                    }
                    else{
                       message="*** Password and confirm Password does'nt match ***";
                       url="/register.jsp"; 
                    } 
                }
                }              
             catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message", message);
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
                message=" Your Doubt has been sucessfully posted";
               } catch (SQLException ex) {
                   Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
              }  
                }
                
                // send email to user
                url="/contact.jsp";
                request.setAttribute("message", message);
                    }
        else if(action.equals("sentmails")){
                ArrayList<Doubt> sentlist = new ArrayList<Doubt>();
                    sentlist = UserDB.selectSent();
                    request.setAttribute("sentlist", sentlist);
                    url="/SentMail.jsp";
                    }
                 
        else if(action.equals("editprofile")){
            try {
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String Email=request.getParameter("email");
                String Sex=request.getParameter("sex");
                String Password=request.getParameter("userpass");
                String cnfrmpass=request.getParameter("confirmpass");
                String Phone=request.getParameter("phone");
                String Age=request.getParameter("age");
                String License=request.getParameter("license");
                String Zip=request.getParameter("zip");
                if(Password.equals(cnfrmpass)){
                 Users user=new Users();
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmail(Email);
                user.setSex(Sex);
                user.setPassword(Password);
                user.setPhone(Phone);
                user.setAge(Age);
                user.setLicenseId(License);
                user.setZip(Zip);
                UserDB.update(user);
                // send email to user
                url="/Login.jsp";
                String to = Email;
                String from = "mannu610@gmail.com";
                String subject = "Profile Updated";
                String body = "Dear " + firstName 
                                + ",\n\n"  + "Your Profile details has been susessfully updated.\n "
                                     + "Have a great day\n\n"
                                       + "Thanks & Regards,\n"+
                                         "Sai Manohar Yerra.\n";
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
                                             + "TO: " + Email + "\n"
                                             + "FROM: " + from + "\n"
                                             + "SUBJECT: " + subject + "\n\n"
                                             + body + "\n\n");
                       }
                 
                    }
                    else{
                       message="*** Password and confirm Password does'nt match ***";
                       url="/register.jsp"; 
                    } 
                
                }              
             catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message", message);
        } 
        else if(action.equals("login")){
            try {
                String email = request.getParameter("username");
                String password = request.getParameter("userpass");
                if(email.equals("admin@admin.com") && password.equals("admin")){
                    ArrayList<Doubt> doubtlist = new ArrayList<Doubt>();
                    doubtlist = UserDB.selectQueries();
                    request.setAttribute("doubtlist", doubtlist);
                    url="/Welcomeadmin.jsp";
                }else{
                    ArrayList<String> hashed = new ArrayList<String>(); 
                    hashed = hashAndSaltPassword(password,email);
                if(UserDB.checkLogin(email,hashed.get(1))){
                HttpSession session = request.getSession();
                Users user = UserDB.selectUser(email);
                session.setAttribute("user", user);
                // add a cookie that stores the user's email to browser
                Cookie c = new Cookie("emailCookie", email);
                c.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
                c.setPath("/");              // allow entire app to access it
                response.addCookie(c);
                if(session.getAttribute("carCode")==null){
                    url="/SelectCar.jsp";
                }else{
                   url="/BookCar.jsp"; 
                }
                }else{
                    message="Please enter correct credentials";
                    url="/Login.jsp";
                }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message", message);
        }
        else if(action.equals("resetpass")){
                String email = request.getParameter("email");
                String password = request.getParameter("pass");
                String repassword = request.getParameter("repass");
                System.out.println("email"+email+"pass"+password+"repass"+repassword);
                if(password.equals(repassword)){
                    try {
                        ArrayList<String> passwordlist = new ArrayList<String>();
                        passwordlist = hashAndSaltPassword(password,email);
                        UserDB.resetpass(email,passwordlist.get(1));
                        url="/Login.jsp";
                        message = " Login with your new credentials";
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    message = " Password & Re-Password does'nt match";
                    url="resetpass.jsp";
                }
            request.setAttribute("message", message);
        }else if(action.equals("getpass")){
            String email = request.getParameter("email");
            String firstname = request.getParameter("firstname");
            String pass =UserDB.getpass(email,firstname);
            if(pass==null||pass.length()==0){
                message="The following credentials does'nt match with our records";
                url="/ForgotPass.jsp";
            }else{
                message = "Link has been sent to Registered e-mail";
                url="/Login.jsp";
                String uuid = UUID.randomUUID().toString();
                String link = "http://localhost:8080/Rentz/resetpass.jsp?action=resetpwd&value=" + uuid + "&mail=" + email;
                // send email to user
                String to = email;
                String from = "mannu610@gmail.com";
                String subject = "Regarding Password Recovery";
                String body = "Dear " + firstname + ",\n\n"
                              + "Your password Recovery Link is below. Click on that..."+"\n"
                              + link
                                  + "\n\n "
                                     + "Have a great day\n\n"
                                       + "Thanks & Regards,\n"+
                                         "Sai Manohar Yerra.\n";
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
                                             + "TO: " + email + "\n"
                                             + "FROM: " + from + "\n"
                                             + "SUBJECT: " + subject + "\n\n"
                                             + body + "\n\n");
                       }
            }
            request.setAttribute("message", message);
        }
        else if(action.equals("checkUser")){
            url = checkUser(request, response);
        }else if(action.equals("Logout")){
            request.getSession().invalidate();
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            url= "/index.html";
        }
        else if(action.equals("reply")){
            String doubtid = (String) request.getParameter("id");
            Doubt doubt = UserDB.selectdoubt(doubtid);
            request.setAttribute("doubt", doubt);
            url= "/Sendreply.jsp";
        }else if(action.equals("booking")){
            String indate = request.getParameter("startdate");
            String outdate = request.getParameter("enddate");
            System.out.println("Start"+indate+"/n"+"End"+outdate);
            if(indate.equals(outdate)){
                message=" Pick-Up and Drop-Off Dates should be different";
                url="/BookCar.jsp";
            }else{
            if(Checkweekday(indate, outdate)){
               message="The Specified location is closed on Saturday and Sunday ";
               url="/BookCar.jsp"; 
            }
            else{
                String location = request.getParameter("location");
                String intime = request.getParameter("starttime");
                String outtime = request.getParameter("endtime");
                HttpSession session = request.getSession();
                String carcode = (String) session.getAttribute("carCode");
                if(Checkbookingdetails(intime,outtime,indate,outdate,location,carcode)){
                    message="The car is not available with selected timings ";
                    url="/BookCar.jsp";
                }else{
                    try {
                        Cars car = new Cars();
                        url="/ConfirmBooking.jsp";
                        Users user = (Users)session.getAttribute("user");
                        car.setEmail(user.getEmail());
                        car.setIndate(indate);
                        car.setIntime(intime);
                        car.setOutdate(outdate);
                        car.setOuttime(outtime);
                        car.setLocation(location);
                        String retlocation = request.getParameter("return");
                        //Calculating Time Difference
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate date1 = LocalDate.parse(indate, formatter);
                        LocalDate date2 = LocalDate.parse(outdate, formatter);
                        Long days = (ChronoUnit.DAYS.between(date1, date2));
                        int no_days=days.intValue();
                        System.out.println("No.of days"+days);
                        Cost cost = new Cost();
                        
                        if(retlocation==null){
                            car.setReturnloc("NO");
                            cost.setRetlocation(0);
                        }else{
                            car.setReturnloc("YES");
                            cost.setRetlocation(50);
                        }
                        String liable = request.getParameter("liable");
                        if(liable==null){
                            car.setLiablePro("NO");
                            cost.setLiability(0);
                        }else{
                            car.setLiablePro("YES");
                            cost.setLiability(no_days*10);
                        }
                        String FullPro = request.getParameter("fullpro");
                        if(FullPro==null){
                            car.setFullPro("NO");
                            cost.setFull(0);
                        }else{
                            car.setFullPro("YES");
                            cost.setFull(no_days*15);
                        }
                        
                        System.out.println(carcode);
                        Cars cardata =UserDB.Selectcar(carcode);
                        
                        cost.setDays(no_days);
                        cost.setCarcost(no_days*Integer.parseInt(cardata.getCost()));
                        cost.setTax(((cost.getCarcost()+cost.getFull()+cost.getLiability()+cost.getRetlocation())*5)/100);
                        cost.setFinalcost(cost.getCarcost()+cost.getFull()+cost.getLiability()+cost.getRetlocation()+cost.getTax());
                        session.setAttribute("cost", cost);
                        session.setAttribute("car", car);
                        request.setAttribute("car",car);
                        request.setAttribute("cardata",cardata);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
            request.setAttribute("message", message);
        }else if(action.equals("ConfirmBooking")){
            HttpSession session = request.getSession();
            Cars car = (Cars)session.getAttribute("car");
            String carcode = (String) session.getAttribute("carCode");
            String indate = car.getIndate();
            String outdate= car.getOutdate();
            String model = carcode;
            String intime =car.getIntime();
            String outtime =car.getOuttime();
            String location = car.getLocation();
            Users user = (Users)session.getAttribute("user");
            String email= user.getEmail();
            Cost cost = (Cost)session.getAttribute("cost");
            float finalcost= cost.getFinalcost();
            Booking book = new Booking();
            book.setAmount(finalcost);
            book.setEmail(email);
            book.setIndate(indate);
            book.setIntime(intime);
            book.setLocation(location);
            book.setModel(model);
            book.setOutdate(outdate);
            book.setOuttime(outtime);
            try {
                UserDB.insertbooking(book);
                message =" Your Booking Details has been mailed to registered e-mail";
                url="/SelectCar.jsp";
                String to = email;
            String from = "mannu610@gmail.com";
            String subject = "Booking Confirmation";
            String body = "Dear " + user.getFirstname()
                    + ",\n\n"  + "Your reservation has been sucessfully confirmed \n\n "
                    
                    + "BOOKING DETAILS:\n "
                    + "Car Model: "+model+"\n"
                    + "Pick-Up Date:" +indate+"\n"
                    + "Pick-Up Time:" +intime +":00\n"
                    + "Drop-Off Date:" +outdate +"\n"
                    + "Drop-Off Time:" +outtime +":00\n"
                    + " Final Cost: $"+finalcost +"\n\n"
                    + "Have a great day\n\n"
                    + "Thanks & Regards,\n"+
                    "Sai Manohar Yerra.\n";
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
                        + "TO: " + email + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n\n"
                        + body + "\n\n");
            }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message", message);
        }else if(action.equals("checksession")){
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            if(user==null){
                url="/Login.jsp";
            }else{
                ArrayList bookinglist = new ArrayList();
                bookinglist = UserDB.selectBooking(user.getEmail());
                url="/Mybooking.jsp";
                request.setAttribute("bookinglist", bookinglist);
            }
            
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
            String subject = "Reply from Rent-A-Car";
            String body = "Dear " + doubt.getName()
                    + ",\n\n"  + reply +"\n\n"
                    + "Have a great day\n\n"
                    + "Thanks & Regards,\n"+
                    "Sai Manohar Yerra.\n";
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
        else if(action.equals("delete")){
            
                String indate = request.getParameter("indate");
                String intime = request.getParameter("intime");
                if(checkpast(indate,intime)){
                    message = " Past Rides cannot be cancelled";
                    url="/Mybooking.jsp";
                    HttpSession session = request.getSession();
                        Users user = (Users) session.getAttribute("user");
                        ArrayList bookinglist = new ArrayList();
                         bookinglist = UserDB.selectBooking(user.getEmail());
                         request.setAttribute("bookinglist", bookinglist); 
                }else{
                    try {
                        UserDB.deletebooking(indate,intime);
                        HttpSession session = request.getSession();
                        Users user = (Users) session.getAttribute("user");
                        ArrayList bookinglist = new ArrayList();
                         bookinglist = UserDB.selectBooking(user.getEmail());
                         url="/Mybooking.jsp";
                         message = " Your ride has been sucessfully cancelled";
                        request.setAttribute("bookinglist", bookinglist); 
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
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

    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        String carCode = request.getParameter("carCode");
        HttpSession session = request.getSession();
        session.setAttribute("carCode", carCode);
        Users user = (Users) session.getAttribute("user");
        
        String url=null;
        // if User object doesn't exist, check email cookie
        if (user == null) {
         /*   Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
            // if cookie doesn't exist, go to Registration page
            if (emailAddress == null || emailAddress.equals("")) {  */
                url = "/Login.jsp";
         /*   }else {
                try {
                    user = UserDB.selectUser(emailAddress);
                    System.out.println("Username"+user.getFirstname());
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("user", user);  */
            }
         else{
            url = "/BookCar.jsp";
        }
        return url;
    }

    private boolean Checkweekday(String indate, String outdate) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date inputdate = formatter.parse(indate);
            Date outputdate = formatter.parse(outdate);
            Calendar incalendar = Calendar.getInstance();
            incalendar.setTime(inputdate);
            Calendar outcalendar = Calendar.getInstance();
            outcalendar.setTime(outputdate);
            int inday = incalendar.get(Calendar.DAY_OF_WEEK);
            int outday = outcalendar.get(Calendar.DAY_OF_WEEK);
            if (inday == Calendar.SATURDAY || inday == Calendar.SUNDAY ||outday == Calendar.SATURDAY || outday == Calendar.SUNDAY) {
               return true;
            }
            else{
                return false;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    

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

    private boolean Checkbookingdetails(String intime, String outtime, String indate, String outdate, String location, String carcode) {
        Booking checkbooking = new Booking();
        checkbooking.setIndate(indate);
        checkbooking.setIntime(intime);
        checkbooking.setOutdate(outdate);
        checkbooking.setOuttime(outtime);
        checkbooking.setLocation(location);
        checkbooking.setModel(carcode);
         Boolean Check =UserDB.Checkbooking(checkbooking);
        return Check;
    }
}

    
