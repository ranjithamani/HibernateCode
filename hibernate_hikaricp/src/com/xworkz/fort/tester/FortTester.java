package com.xworkz.fort.tester;

import com.xworkz.fort.dao.FortDAO;
import com.xworkz.fort.dao.FortDAOImpl;
import com.xworkz.fort.entity.FortEntity;

public class FortTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FortEntity entity = new FortEntity("Gwalior Fort", "MP", true);
		FortDAO dao = new FortDAOImpl();
		dao.save(entity);
	}

}
