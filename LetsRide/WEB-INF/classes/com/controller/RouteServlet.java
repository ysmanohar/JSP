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
 * Servlet implementation class RouteServlet
 */
@WebServlet("/routes")
public class RouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		ArrayList<Travel> travel=new ArrayList<Travel>();
		Travel uniqueTravel=new Travel();
		SearchService fetchService=new SearchService();
		travel=fetchService.fetchDriverIdMyRide(name);
		//System.out.println("You are in Ride  Servlet. Fetched travel details are="+travel.get(1).getSource());
		request.setAttribute("travel", travel);
		RequestDispatcher rd=request.getRequestDispatcher("/myposts.jsp");
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
