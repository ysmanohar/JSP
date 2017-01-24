package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Travel;
import com.services.SearchService;

/**
 * Servlet implementation class RideServlet
 */
@WebServlet("/rides")
public class RideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		System.out.println("name fetched in servlet="+name);
		Travel travel=new Travel();
		ArrayList<Travel> travelDetails=new ArrayList<Travel>();
		SearchService fetchService=new SearchService();
		travel=fetchService.fetchRideDetail(name);
		travelDetails=fetchService.fetchTravellerIdMyRide(name);
		System.out.println("You are in Ride  Servlet. Fetched travel details are="+travel.getId());
		request.setAttribute("travelDetails", travelDetails);
		request.setAttribute("travel", travel);
		RequestDispatcher rd=request.getRequestDispatcher("/myrides.jsp");
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
