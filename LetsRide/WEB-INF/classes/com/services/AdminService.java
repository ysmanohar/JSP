package com.services;

import java.util.ArrayList;

import com.dao.AdminDao;
import com.domain.Admin;

public class AdminService implements iAdminConsole{

	@Override
	public int getTotalRideCounts() {
		
		
		int count=AdminDao.getTotalRideCounts();
		return count;
		
		
	}

	@Override
	public ArrayList<Admin> getDetailedRideCounts() {

        Admin admin=new Admin();
        ArrayList<Admin> countStatus=new ArrayList<Admin>();
        countStatus=AdminDao.getDetailedRideCounts();
		return countStatus;
	}

}
