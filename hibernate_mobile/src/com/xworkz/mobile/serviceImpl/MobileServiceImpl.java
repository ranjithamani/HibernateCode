package com.xworkz.mobile.serviceImpl;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;

public class MobileServiceImpl implements MobileService {
	private MobileDAO dao = new MobileDAOImpl();

	@Override
	public int validateAndSave(MobileEntity entity) {
		boolean validatePrice = false;
		boolean validateColor = false;
		boolean validateIsAndroid;
		boolean validateBrand = false;
		if (entity != null) {
			System.out.println("entity is not null,can validate data");
			String brand = entity.getBrand();
			if (brand != null && !brand.isEmpty() && brand.length() > 3 && brand.length() < 8) {
				System.out.println("brand is valid");
				validateBrand = true;
			} else {
				System.out.println("brand is invalid");
				validateBrand = false;
			}
			String color = entity.getColor();
			if (brand != null && !color.isEmpty() && color.length() > 3 && color.length() < 8) {
				System.out.println("color is valid");
				validateColor = true;
			} else {
				System.out.println("color is invalid");
				validateColor = false;
			}
			double price = entity.getPrice();
			if (price > 5000 && price < 20000) {
				System.out.println("price is valid");
				validatePrice = true;
			} else {
				System.out.println("price is invalid");
				validatePrice = false;
			}
			Boolean isAndroid = entity.isAndroid();
			if (isAndroid != null) {
				System.out.println("isAndroid is valid");
				validateIsAndroid = true;
			} else {
				System.out.println("isAndroid is invalid");
				validateIsAndroid = false;
			}

			if (validateBrand && validatePrice && validateIsAndroid && validateColor) {
				System.out.println("running successfully,success");
				dao.save(entity);
				return 1;
			}
		} else {
			System.out.println("entity is null");
		}

		return 0;
	}

	@Override
	public void validateAndReadAllRecords() {
		dao.readAllRecords();
	}

	@Override
	public void validateAndUpdatePriceByColor(double price,String color) {
		dao.updatePriceByColor(price, color);
	}

	@Override
	public double validateAndfindTotalPrice() {
		return dao.findTotalPrice();
	}

	@Override
	public double validateAndfindMaxPrice() {
		// TODO Auto-generated method stub
		return dao.findMaxPrice();
	}

	@Override
	public double validateAndfindMinPrice() {
		// TODO Auto-generated method stub
		return dao.findMinPrice();
	}

	@Override
	public double validateAndFindMobilePriceByBrand(String brand) {
		// TODO Auto-generated method stub
		return dao.findMobilePriceByBrand(brand);
	}

	@Override
	public void validateAndDeleteRowById(int id) {
		dao.deleteRowById(id);
	}
}
