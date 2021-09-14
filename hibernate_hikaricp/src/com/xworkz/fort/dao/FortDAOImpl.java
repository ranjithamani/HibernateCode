package com.xworkz.fort.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.fort.entity.FortEntity;
import com.xworkz.fort.util.SFUtil;

public class FortDAOImpl implements FortDAO{
private	SessionFactory factory=SFUtil.getFactory();
Transaction trans=null;
	@Override
	public int save(FortEntity entity) {
		int key = 0;
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			key = (int) session.save(entity);
			trans.commit();
			System.out.println(key);

		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return key;
	}
}
