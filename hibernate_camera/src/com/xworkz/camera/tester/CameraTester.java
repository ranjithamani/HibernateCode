package com.xworkz.camera.tester;

import com.xworkz.camera.dao.CameraDAO;
import com.xworkz.camera.dao.CameraDAOImpl;
import com.xworkz.camera.entity.CameraEntity;

public class CameraTester {

	public static void main(String[] args) {
		CameraEntity entity = new CameraEntity("Canon ","Canon ","EOS 1500D",26.2d,true,6.62d, 6,"Standard  ","thermoplastic");

		CameraDAO dao = new CameraDAOImpl();
		dao.save(entity);
		CameraEntity temp=dao.readById(1);
		System.out.println(temp);
		dao.updateBrandById(1, "Panasonic");
		//dao.deleteById(2);
	}

}
