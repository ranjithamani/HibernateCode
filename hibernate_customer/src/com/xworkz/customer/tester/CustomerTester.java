package com.xworkz.customer.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.entity.CustomerEntity;
import com.xworkz.customer.entity.constants.Gender;

public class CustomerTester {

	public static void main(String[] args) {
		List<CustomerEntity> customerEntities= new ArrayList<CustomerEntity>();
		
		for(int i=0; i<100;i++) 
		{
		CustomerEntity entity = new CustomerEntity("Ranjitha"+1,8073721260l,"Bangalore",Gender.FEMALE);
		//CustomerEntity entity1 = new CustomerEntity("Devika",9901351673l,"Bihar",Gender.FEMALE);
		//CustomerEntity entity2 = new CustomerEntity("Harish",9538206467l,"Kadapa",Gender.MALE);
		customerEntities.add(entity);
		//customerEntities.add(entity1);
		//customerEntities.add(entity2);

		}
		System.out.println(customerEntities.size());
		
		CustomerDAO dao = new CustomerDAOImpl();
		//dao.save(entity);

		//dao.save(entity1);
		//dao.save(entity2);
		dao.saveList(customerEntities);
		//dao.readById(22);
        //dao.loadById(3);

	}

}
