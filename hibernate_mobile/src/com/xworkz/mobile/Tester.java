package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class Tester {

	public static void main(String[] args) {
		MobileEntity entity = new MobileEntity(22000.5, "black", true);
		
		MobileDAO dao = new MobileDAOImpl();
	    dao.save(entity);
		dao.read(1);
	}

}
