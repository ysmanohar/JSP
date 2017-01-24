package com.services;

import java.util.ArrayList;

import com.dao.TravelDao;
import com.domain.Travel;

public class TravelService {
	
	public boolean postItirenary(ArrayList<String> pickupArray,ArrayList<Long> distArray)
	{
		boolean posted = false;
		Travel travel=new Travel();
		 for(int a=0;a<pickupArray.size();a++)
	        {
	        	travel.setSource(pickupArray.get(a));
	        	System.out.println("Inserting Source="+pickupArray.get(a));
	        	for(int b=a+1;b<pickupArray.size();b++)
	        	{
	        		System.out.println("Inserting number="+b);
	        		travel.setDestination(pickupArray.get(b));
	        		travel.setDistance(distArray.get(b));
	        		posted=TravelDao.postTravel(travel);
	        		System.out.println("Inserting Destination="+pickupArray.get(b));
	        	}
	        }
		 System.out.println("Tavel Service posted value="+posted);
		return posted;
	}
	
	
	
	public boolean postTravel(Travel travel)
	{
		boolean posted;
		System.out.println(travel.getUserid());
		int pricePerUnit=travel.getPrice();
		long distance=travel.getDistance();
		int capacity=travel.getCapacity();
		//int pricePerPerson=(int) (pricePerUnit*distance/capacity);
		travel.setPrice(pricePerUnit);
		posted=TravelDao.postTravel(travel);
		System.out.println("psted in service class"+posted);
		return posted;
	}

	public int fetchUserID(String firstname) {
		// TODO Auto-generated method stub
		
		System.out.println("Service travel::"+firstname);
		int userid=TravelDao.fetchUserId(firstname);
		return userid;
	}



	public void deleteMyRides(int travelid) {
		// TODO Auto-generated method stub
		TravelDao.deleteMyRides(travelid);
		
	}



	public void deleteDriverPost(int travelid) {
		// TODO Auto-generated method stub
		TravelDao.deleteDriverPost(travelid);
		
	}

}
