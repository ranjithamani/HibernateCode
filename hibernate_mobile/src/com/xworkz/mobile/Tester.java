package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class Tester {

	public static void main(String[] args) {
		MobileEntity entity = new MobileEntity(2000.5d, "Black", true, "VIVO");
		MobileEntity entity1 = new MobileEntity(3555.5d, "Red", true, "MI");

		MobileDAO dao = new MobileDAOImpl();
		dao.save(entity);
		dao.save(entity1);
		System.out.println("**************************");
		dao.readAllRecords();
		System.out.println("*******************");
		double price = dao.findMobilePriceByBrand("MI");
		System.out.println(price);

		double TotalPrice = dao.findTotalPrice();
		System.out.println(TotalPrice);

		double maxPrice = dao.findMaxPrice();
		System.out.println(maxPrice);

		double minPrice = dao.findMinPrice();
		System.out.println(minPrice);

		dao.updatePriceByColor();
		dao.deleteRowById();
	}

}
