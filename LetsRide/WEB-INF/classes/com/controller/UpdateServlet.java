package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.services.LoginService;
import com.services.SearchService;
import com.services.iService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		User user=new User();
		String name=request.getParameter("name");
        System.out.println("Update Servlet"+name);
	    SearchService searchService=new SearchService();
         user=searchService.searchBySessionName(name);  
         System.out.println("User fetched in update Servlet whose details need to be redirected to front end="+user.getEmail());
         request.setAttribute("user", user);
         RequestDispatcher view = request.getRequestDispatcher("/update.jsp");
         view.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user=new User();
		int id=Integer.parseInt(request.getParameter("id"));
		Long phone=Long.parseLong(request.getParameter("phone"));
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		Long zip=Long.parseLong(request.getParameter("zip"));
		
		user.setId(id);
		user.setPhone(phone);
		user.setAddress(address);
		user.setCity(city);
		user.setZip(zip);
		
		System.out.println("Sending the user to update to the service class="+user.getId());
		iService service=new LoginService();
		service.updateUser(user);
		RequestDispatcher view = request.getRequestDispatcher("/updateSuccess.jsp");
		view.forward(request, response);
				
		
		
	}

}
