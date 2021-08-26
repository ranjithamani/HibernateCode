package com.xworkz.soap.tester;

import com.xworkz.soap.constant.SoapType;
import com.xworkz.soap.dao.SoapDAO;
import com.xworkz.soap.dao.SoapDAOImpl;
import com.xworkz.soap.dto.SoapDTO;

public class SoapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoapDTO dto = new SoapDTO(3, "Varun Dhawan", "Sandal", true, false, SoapType.HUMAN);

		SoapDAO dao = new SoapDAOImpl();
		dao.save(dto);
		SoapDTO temp = dao.readById(1);
		System.out.println(temp);
	}

}
