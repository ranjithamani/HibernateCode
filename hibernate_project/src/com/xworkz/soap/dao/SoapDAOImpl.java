package com.xworkz.soap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.soap.dto.SoapDTO;

public class SoapDAOImpl implements SoapDAO {
	@Override
	public int save(SoapDTO entity) {
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(SoapDTO.class);
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		int primaryKey = (int)session.save(entity);
		trans.commit();
		System.out.println(primaryKey);
		session.close();
		factory.close();
		return primaryKey;
	}
}
