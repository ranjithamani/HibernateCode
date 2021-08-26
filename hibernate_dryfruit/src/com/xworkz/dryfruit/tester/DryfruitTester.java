package com.xworkz.dryfruit.tester;

import com.xworkz.dryfruit.dao.DryfruitDAO;
import com.xworkz.dryfruit.dao.DryfruitDAOImpl;
import com.xworkz.dryfruit.dto.DryfruitDTO;

public class DryfruitTester {

	public static void main(String[] args) {
		DryfruitDTO dto = new DryfruitDTO(3,"Date","Markstor","India", 1000, "Amazon");

		DryfruitDAO dao = new DryfruitDAOImpl();
		dao.save(dto);
		DryfruitDTO temp=dao.readById(2);
		System.out.println(temp);
	}

}
