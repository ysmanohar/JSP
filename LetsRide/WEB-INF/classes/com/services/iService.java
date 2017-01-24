package com.services;

import com.domain.Travel;
import com.domain.User;

public interface iService {
	
	public User fetchUser(int driverId);
	public void updateBookingDetail(Travel travel);
	public void updateUser(User user);
	

}
