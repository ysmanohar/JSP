package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Travel;
import com.domain.User;
import com.services.LoginService;
import com.services.TravelService;

/**
 * Servlet implementation class TravelServlet
 */
@WebServlet("/postiti")
public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        //Look at this piece of code everytime you run
        
        int id=8;
        Date date=new Date();;
        //HttpSession session = request.getSession(); 
        //User user =(User) session.getAttribute("name");
        //User user=(User) request.getSession(false).getAttribute("name");
        //System.out.println(user.getId());
        //System.out.println(user.getFirstname());
        //Fetching multiple sources
       // int count=Integer.parseInt(request.getParameter("count"));
        //ArrayList<String> pickArray=new ArrayList<String>();
        //ArrayList<Integer> pickDistArray=new ArrayList<Integer>();
        System.out.println("travel servlet: count");
       

        
        TravelService travelService=new TravelService();
        String firstname=request.getParameter("sessionId");
        int userid=travelService.fetchUserID(firstname);
        System.out.println("this is the userId:"+userid);
        String source=request.getParameter("source");    
        String destination=request.getParameter("destination");  
        int price=Integer.parseInt(request.getParameter("price"));    
        Long distance=Long.parseLong(request.getParameter("distance")); 
        int capacity=Integer.parseInt(request.getParameter("capacity")); 
        //Working on Date variable
        String startDateStr = request.getParameter("day");
        System.out.println("stsartdate Str"+startDateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	date=sdf.parse(startDateStr);
			System.out.println("date entered is="+date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        int hour=Integer.parseInt(request.getParameter("hour")); 
        int minute=Integer.parseInt(request.getParameter("minute")); 
        
              
        Travel travel=new Travel();
        
        travel.setSource(source);
        travel.setDestination(destination);
        travel.setPrice(price);
        travel.setDistance(distance);
        travel.setUserid(userid);
        travel.setId(id);
        travel.setCapacity(capacity);
        travel.setDate(date);
        travel.setHour(hour);
        travel.setMinute(minute);
        
        
        
        boolean userInserted;
     /*   boolean userInserted=travelService.postTravel(travel);
        System.out.println("user inserted="+userInserted); */
        int i=1;
      //  while(request.getParameter("additem_"+i+"")!=null)
       //{
        /*String initPickup=request.getParameter("additem_"+i+"");
        int initPickupDist=Integer.parseInt(request.getParameter("srcDist_"+i+""));
        travel.setDestination(initPickup);
        travel.setDistance(initPickupDist);
        userInserted=travelService.postTravel(travel);
        travel.setSource(initPickup);
        i=i+1;
         }
        travel.setDestination(destination);
        userInserted=travelService.postTravel(travel); */
        
        
        //Going for every combinations:
        ArrayList<String> pickupArray=new ArrayList<String>();
        pickupArray.add(source);
        ArrayList<Long> distArray=new ArrayList<Long>();
        distArray.add((long) 0);
        int count=0;
        while(request.getParameter("additem_"+i+"")!=null)
       {
        	distArray.add(Long.parseLong(request.getParameter("srcDist_"+i+"")));
        	pickupArray.add(request.getParameter("additem_"+i+""));
            i++;
            count=i;
       }
        pickupArray.add(destination);
        distArray.add(distance);
        
        System.out.println("pickupPoints entered="+pickupArray);
        System.out.println("Distances entered="+distArray);
        
       // boolean userInsert=travelService.postItirenary(pickupArray, distArray);
        
       for(int a=0;a<pickupArray.size();a++)
        {
        	travel.setSource(pickupArray.get(a));
        	System.out.println("Inserting Source="+pickupArray.get(a));
        	for(int b=a+1;b<pickupArray.size();b++)
        	{
        		System.out.println("Inserting number="+b);
        		travel.setDestination(pickupArray.get(b));
        		long distanceFromSource=(distArray.get(b)-distArray.get(a));
        		travel.setDistance(distanceFromSource);
        		userInserted=travelService.postTravel(travel);
        		System.out.println("Inserting Destination="+pickupArray.get(b));
        	}
        }
        /*int totalPoints=count+2;
        int factorial=1;
        
        //Calculation of factorial nPr
        for(int j=1;j<=totalPoints;j++)
        {
            factorial=factorial*j;
            
        }
        //Calculation of total combinations
        int totalCombinations=(factorial/(count*2));
        
    
        
       
        	
        travel.setDestination(destination);
        userInserted=travelService.postTravel(travel);*/
        
       // }
       // if(userInserted)
       // {
        	response.sendRedirect("postSuccess.jsp");
        	//RequestDispatcher rd=request.getRequestDispatcher("postSuccess.jsp");
        	//rd.forward(request, response);
        	       	
       // }
        
      
       // else
       // {
        	//out.print("<p style=\"color:red\">Passwords do not match!</p>");
        	//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
      //  }
  
        out.close();    
		
		
	}

}
