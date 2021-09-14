package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {
	int validateAndSave(MobileEntity entity);

	void validateAndReadAllRecords();

	double validateAndFindMobilePriceByBrand(String brand);

	double validateAndfindTotalPrice();

	double validateAndfindMaxPrice();

	double validateAndfindMinPrice();

	void validateAndUpdatePriceByColor( double price,String color);

	void validateAndDeleteRowById(int id);

}
