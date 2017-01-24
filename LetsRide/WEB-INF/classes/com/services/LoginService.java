package com.services;

import java.util.ArrayList;

import com.dao.LoginDao;
import com.domain.Travel;
import com.domain.User;

public class LoginService implements iService {

	public User validate(String n, String p) {
		// TODO Auto-generated method stub
		User user =new User();
		user=LoginDao.validate(n, p);
		return user;
	}
	
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean isRegistered=LoginDao.registerUser(user);
		return isRegistered;
	}

	@Override
	public User fetchUser(int driverId) {
		// TODO Auto-generated method stub
		User user=new User();
		user=LoginDao.fetchUser(driverId);
		return user;
	}

	@Override
	public void updateBookingDetail(Travel travel) {
		// TODO Auto-generated method stub
		User user=new User();
		boolean updated;
		ArrayList<Travel> bookingTravelList=new ArrayList<Travel>(); 
		SearchService searchAllAffectedPath=new SearchService();
		bookingTravelList=searchAllAffectedPath.searchByBooking(travel.getUserid(),travel.getDate(),travel.getSource());
		int capacity=bookingTravelList.get(0).getCapacity()-1;
		System.out.println("List size="+bookingTravelList.size());
		for(int i=0;i<bookingTravelList.size();i++)
		{
		  
		  bookingTravelList.get(i).setCapacity(capacity);
		  updated=LoginDao.updateBooking( bookingTravelList.get(i));  		
	     }
	
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		LoginDao.updateUser(user);
		
	}
	
	public void updateMyRides(Travel travel,int userid)
	{
		System.out.println("In the service class-user id to update myride table="+userid);
		LoginDao.updateMyRides(travel,userid);
	}

}
