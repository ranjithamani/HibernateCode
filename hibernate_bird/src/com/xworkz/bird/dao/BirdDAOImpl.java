package com.xworkz.bird.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bird.entity.BirdEntity;

public class BirdDAOImpl implements BirdDAO {
	@Override
	public int save(BirdEntity entity) {
		Configuration configure = new Configuration().configure().addAnnotatedClass(BirdEntity.class);
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		int primaryKey = (int) session.save(entity);
		trans.commit();
		System.out.println(primaryKey);
		session.close();
		factory.close();

		return primaryKey;
	}

	@Override
	public BirdEntity readById(int primaryKey) {
		Configuration configure = new Configuration().configure().addAnnotatedClass(BirdEntity.class);
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		BirdEntity database = session.get(BirdEntity.class, primaryKey);
		return database;
	}
}
