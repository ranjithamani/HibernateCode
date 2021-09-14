package com.xworkz.mobile;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.serviceImpl.MobileServiceImpl;

public class Tester {

	public static void main(String[] args) {
		MobileEntity entity = new MobileEntity(2000.5d, "Black", true, "VIVO");
		MobileEntity entity1 = new MobileEntity(3555.5d, "Red", true, "MI");

		MobileService service = new MobileServiceImpl();

		service.validateAndSave(entity);
		service.validateAndSave(entity1);

		System.out.println("******************");
		service.validateAndReadAllRecords();

		System.out.println("**********************************");
		double price = service.validateAndFindMobilePriceByBrand("MI");
		System.out.println(price);

		System.out.println("**********************");
		double maxPrice = service.validateAndfindMaxPrice();
		System.out.println("mobile maxPrice is:" + maxPrice);

		System.out.println("**********************************");
		double minPrice = service.validateAndfindMinPrice();
		System.out.println("mobile minPrice is:" + minPrice);

		System.out.println("***********************************");
		double totalPrice = service.validateAndfindTotalPrice();
		System.out.println("mobile totalPrice is:" + totalPrice);

		System.out.println("***************************");
		service.validateAndUpdatePriceByColor(85000, "Red");

		System.out.println("**********************");
		service.validateAndDeleteRowById(1);
	}

}
