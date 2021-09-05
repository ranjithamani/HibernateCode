package com.xworkz.customer.dao;

import java.util.List;

import com.xworkz.customer.entity.CustomerEntity;

public interface CustomerDAO {

	int save(CustomerEntity entity);

	CustomerEntity readById(int primaryKey);

	void updateNameById(int id, String name);

	default void saveList(List<CustomerEntity> entity) {
	}

	CustomerEntity loadById(int id);

}
