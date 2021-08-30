package com.xworkz.bird.tester;

import com.xworkz.bird.dao.BirdDAO;
import com.xworkz.bird.dao.BirdDAOImpl;
import com.xworkz.bird.entity.BirdEntity;

public class BirdTester {

	public static void main(String[] args) {
		BirdEntity entity = new BirdEntity(17,"Pikachu","Cocktail",true,false,true,15,"Cacatuidae"," Australia",true);

		BirdDAO dao = new BirdDAOImpl();
		dao.save(entity);
		
		BirdEntity temp=dao.readById(1);
		System.out.println(temp);
		
		dao.updateNameById(4, "Crow");
		dao.deleteById(9);
	}

}
