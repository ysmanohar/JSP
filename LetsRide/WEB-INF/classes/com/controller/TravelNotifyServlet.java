package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Action;
import com.domain.Notification;
import com.domain.Travel;
import com.domain.User;
import com.services.LoginService;
import com.services.ObserveNotif;
import com.services.SearchService;
import com.services.iObserver;

/**
 * Servlet implementation class TravelNotifyServlet
 */
@WebServlet("/travelnotification")
public class TravelNotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelNotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Notification> notifications=new ArrayList<Notification>();
		ArrayList<Integer> travelId=new ArrayList<Integer>();
		ArrayList<String> source=new ArrayList<String>();
		ArrayList<String> destination=new ArrayList<String>();
		ArrayList<String> usersFetchedForNotify=new ArrayList<String>();
		String name=request.getParameter("name");
		System.out.println("NotifyServlet: name="+name);
		iObserver observe=new ObserveNotif();
		notifications=observe.notification(name);
		//System.out.println("Travel Notify Servlet: First Travel id fetched="+notifications.get(0).getTravelid());
		//Fetching travel details for all the travel ids fetched
		if(notifications.size()!=0)
		{
		for(int i=0;i<notifications.size();i++)
		{
			Travel travel=new Travel();
			travelId.add(notifications.indexOf(i));
			SearchService fetchName=new SearchService();
			source.add(fetchName.fetchBookingDetail(notifications.get(i).getTravelid()).getSource());
			destination.add(fetchName.fetchBookingDetail(notifications.get(i).getTravelid()).getDestination());
			//fetching driver id
			User user=new User();
			LoginService fetchDriverName=new LoginService();
			user=fetchDriverName.fetchUser(notifications.get(i).getDriverid());
			usersFetchedForNotify.add(user.getFirstname());
		}
		}
		
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
		request.setAttribute("notifications", notifications);
		request.setAttribute("drivernamelist", usersFetchedForNotify);
		RequestDispatcher rd=request.getRequestDispatcher("/travelnotification.jsp");
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
