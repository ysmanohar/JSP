package com.services;

import java.util.ArrayList;
import java.util.Date;

import com.dao.SearchDao;
import com.domain.Travel;
import com.domain.User;

public class SearchService {

	public ArrayList<Travel> searchByName(String pid,String destination) {
		// TODO Auto-generated method stub
		Travel travel=new Travel();
		ArrayList<Travel> searchList=new ArrayList<Travel>();
		SearchDao searchDao=new SearchDao();
		searchList=searchDao.searchByName(pid,destination);
		return searchList;
		
	}

	public Travel fetchBookingDetail(int travelid) {
		// TODO Auto-generated method stub
		Travel bookTravel=new Travel();
		bookTravel=SearchDao.fetchBookingDetail(travelid);
		return bookTravel;
		
	}

	public ArrayList<Travel> searchByBooking(int driverId, Date date, String source)
	{
		ArrayList<Travel> bookingTravel=new ArrayList<Travel>();
		bookingTravel=SearchDao.searchByBooking(driverId,date,source);
		return bookingTravel;
		
	}

	public User searchBySessionName(String name) {
		// TODO Auto-generated method stub
		User user=new User();
		System.out.println("You are in Search Servlet by firstname stored in session.Searching.."+name);
		user=SearchDao.searchBySessionName(name);
		return user;
	}

	public int fetchUserId(String userName) {
		// TODO Auto-generated method stub
		System.out.println("You are in Search Servlet for user id using firstname.Searching.."+userName);
		int userid=SearchDao.fetchUserId(userName);
		return userid;
	}

	public Travel fetchRideDetail(String name) {
		
			SearchDao fetchDetail=new SearchDao();
			int userId=fetchDetail.fetchUserId(name);
			ArrayList<Travel> travelDetails=new ArrayList<Travel>();
			System.out.println("Search Service:fetchRideDetail"+userId);
			int travelId=fetchDetail.fetchTravelIdMyRide(userId);
			Travel travel=SearchDao.fetchBookingDetail(travelId);
			return travel;
			
		
	}
	
	public ArrayList<Travel> fetchTravellerIdMyRide(String name) {
		
		ArrayList<Integer> travellerId=new ArrayList<Integer>();
		ArrayList<Travel> travelDetails=new ArrayList<Travel>();
		Travel travel=new Travel();
		SearchDao fetchDetail=new SearchDao();
		int userId=fetchDetail.fetchUserId(name);
		System.out.println("Search Service:fetchRideDetail"+userId);
		travelDetails=fetchDetail.fetchTravellerIdMyRide(userId);
		System.out.println("Search Service: fetchTravellerIdMyRide fetched size= "+travelDetails.size());
		System.out.println("I am here");
		//System.out.println("Travel 1="+travelDetails.get(0).getDestination());
		
		return travelDetails;
}
	
public ArrayList<Travel> fetchDriverIdMyRide(String name) {
		
		ArrayList<Integer> travellerId=new ArrayList<Integer>();
		ArrayList<Travel> travelDetails=new ArrayList<Travel>();
		Travel travel=new Travel();
		SearchDao fetchDetail=new SearchDao();
		int userId=fetchDetail.fetchUserId(name);
		System.out.println("Search Service:fetchRideDetail"+userId);
		travelDetails=fetchDetail.fetchDriverIdMyRide(userId);
		System.out.println("Search Service: fetchTravellerIdMyRide fetched size= "+travelDetails.size());
		System.out.println("I am here at service fetchedDriverIdMyRide");
		//System.out.println("Travel 1="+travelDetails.get(0).getDestination());
		
		return travelDetails;
}


}
