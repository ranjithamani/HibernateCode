package com.xworkz.bird.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.bird.entity.BirdEntity;
import com.xworkz.bird.util.SFUtil;

public class BirdDAOImpl implements BirdDAO {
	@Override
	public int save(BirdEntity entity) {
		SessionFactory factory = SFUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		int primaryKey = (int) session.save(entity);
		trans.commit();
		System.out.println(primaryKey);
		session.close();

		return primaryKey;
	}

	@Override
	public BirdEntity readById(int primaryKey) {
		SessionFactory factory = SFUtil.getFactory();
		Session session = factory.openSession();
		BirdEntity database = session.get(BirdEntity.class, primaryKey);
		return database;
	}

	@Override
	public void updateNameById(int id, String name) {
		SessionFactory factory = SFUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		BirdEntity database = session.get(BirdEntity.class, id);
		database.setName(name);
		session.update(database);
		trans.commit();
		System.out.println(database);
		session.close();
	}

	@Override
	public void deleteById(int id) {
		SessionFactory factory = SFUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		BirdEntity entity =session.get(BirdEntity.class, id);
		session.delete(entity);
		trans.commit();
		session.close();
	}
}
