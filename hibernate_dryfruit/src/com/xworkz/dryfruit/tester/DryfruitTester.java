package com.xworkz.dryfruit.tester;

import com.xworkz.dryfruit.dao.DryfruitDAO;
import com.xworkz.dryfruit.dao.DryfruitDAOImpl;
import com.xworkz.dryfruit.dto.DryfruitDTO;

public class DryfruitTester {

	public static void main(String[] args) {
		DryfruitDTO dto = new DryfruitDTO(2,"Date","Markstor","India", 1000, "Amazon");
		//DryfruitDTO dto1 = new DryfruitDTO(3,"Walnuts","Happilo","India", 1500, "BigBasket");

		DryfruitDAO dao = new DryfruitDAOImpl();
		dao.save(dto);
		//dao.save(dto1);
	}

}
