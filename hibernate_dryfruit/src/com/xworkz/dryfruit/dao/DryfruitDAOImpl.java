package com.xworkz.dryfruit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.dryfruit.dto.DryfruitDTO;

public class DryfruitDAOImpl implements DryfruitDAO {
	@Override
	public int save(DryfruitDTO dto) {
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(DryfruitDTO.class);
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		int primaryKey = (int) session.save(dto);
		trans.commit();
		System.out.println(primaryKey);
		session.close();
		factory.close();

		return primaryKey;
	}
	@Override
	public DryfruitDTO readById(int pk) {
		Configuration configure=new Configuration().configure().addAnnotatedClass(DryfruitDTO.class);
		SessionFactory factory=configure.buildSessionFactory();
		Session session= factory.openSession();
		DryfruitDTO database=session.get(DryfruitDTO.class, pk);
		return database;
	}

}
