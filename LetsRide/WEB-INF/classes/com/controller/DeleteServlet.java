package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.services.TravelService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteride")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int travelid=Integer.parseInt(request.getParameter("travelid"));
		System.out.println("In delete Servlet travelid="+travelid);
		TravelService deleteService=new TravelService();
		deleteService.deleteMyRides(travelid);
		boolean deleted=true;
		request.setAttribute("deleted", deleted);
		RequestDispatcher rd=request.getRequestDispatcher("/deletesuccess.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int travelid=Integer.parseInt(request.getParameter("travelid"));
		TravelService deleteService=new TravelService();
		deleteService.deleteDriverPost(travelid);
		RequestDispatcher rd=request.getRequestDispatcher("/driverdeletesuccess.jsp");
		rd.forward(request, response);
	}

}
