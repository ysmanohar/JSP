package com.services;

import java.util.ArrayList;

import com.dao.NotifyDao;
import com.domain.Action;
import com.domain.Notification;

public class ObserveNotif implements iObserver{

	@Override
	public ArrayList<Notification> notification(String name) {
		
		//COHESION
		
		SearchService searchService=new SearchService();
		int travellerId=searchService.fetchUserId(name);
		ArrayList<Notification> notifications=new ArrayList<Notification>();
		notifications=NotifyDao.fetchByIDNotif(travellerId);
		return notifications;
		
	}

	@Override
	public ArrayList<Notification> notificationDriver(String name) {

		SearchService searchService=new SearchService();
		int travellerId=searchService.fetchUserId(name);
		ArrayList<Notification> notifications=new ArrayList<Notification>();
		notifications=NotifyDao.fetchByIDDriverNotif(travellerId);
		return notifications;
	}
	


}
