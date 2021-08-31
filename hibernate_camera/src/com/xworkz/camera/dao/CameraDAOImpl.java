package com.xworkz.camera.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.camera.entity.CameraEntity;
import com.xworkz.camera.util.SFUtil;

public class CameraDAOImpl implements CameraDAO{
	
	private SessionFactory factory=SFUtil.getFactory();
	
	@Override
	public int save(CameraEntity entity) {
		try(Session session= factory.openSession()){
			Transaction trans=session.beginTransaction();
			int key=(int)session.save(entity);
			trans.commit();
			System.out.println("ranju:"+key);
			return key;
		}
	}
	@Override
	public CameraEntity readById(int primaryKey) {
		try(Session session=factory.openSession()){
			CameraEntity database=session.get(CameraEntity.class, primaryKey);
			return database;
	}
	}
	@Override
	public void updateBrandById(int id, String brand) {
		try(Session session=factory.openSession()){
			Transaction trans=session.beginTransaction();
			CameraEntity database=session.get(CameraEntity.class, id);
			database.setBrand(brand);
			session.update(database);
			trans.commit();
			System.out.println("updated:"+database);
			
		}
		
	}
	@Override
	public void deleteById(int id) {
		try(Session session=factory.openSession()){
			Transaction trans=session.beginTransaction();
			CameraEntity database=session.get(CameraEntity.class, id);
			session.delete(database);
			trans.commit();
			System.out.println("deleted:"+database);
			
		}
	}

}
