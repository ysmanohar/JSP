package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Travel;
import com.domain.User;
import com.services.LoginService;
import com.services.SearchService;
import com.services.iService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/booking")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int travelid=Integer.parseInt(request.getParameter("travelid"));
		String userName=request.getParameter("userfirstname");
		SearchService searchbyNameService=new SearchService();		
		int userid=searchbyNameService.fetchUserId(userName);
		System.out.println("User Id who is booking the travel="+userid);
		System.out.println("Travel ID to book="+travelid);
		Travel bookTravel=new Travel();
		SearchService searchService=new SearchService();
		bookTravel=searchService.fetchBookingDetail(travelid);
		System.out.println("User id fetched="+bookTravel.getUserid());
		iService updateUserService=new LoginService();
		updateUserService.updateBookingDetail(bookTravel);
		int driverId=bookTravel.getUserid();
		iService fetchUserService=new LoginService();
		User user=new User();
		user=fetchUserService.fetchUser(driverId);
		LoginService updateMyRide=new LoginService();
		updateMyRide.updateMyRides(bookTravel, userid);
		System.out.println("returned from fetched user="+user.getId());
		request.setAttribute("bookTravel", bookTravel);
		request.setAttribute("user", user);
                
                
		//
		RequestDispatcher rd=request.getRequestDispatcher("/bookingpage.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
