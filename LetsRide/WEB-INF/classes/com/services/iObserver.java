package com.services;

import java.util.ArrayList;

import com.domain.Action;
import com.domain.Notification;

public interface iObserver {
	
	public ArrayList<Notification> notification(String name);
	public ArrayList<Notification> notificationDriver(String name);

}
