package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {
	
	int save(MobileEntity entity);
    void readAllRecords();
	double findMobilePriceByBrand(String brand);
    double findTotalPrice(); 
    double findMaxPrice();
    double findMinPrice();
    void updatePriceByColor();
    void deleteRowById();
}
