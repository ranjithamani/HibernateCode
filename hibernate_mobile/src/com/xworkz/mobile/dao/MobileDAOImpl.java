package com.xworkz.mobile.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.util.SFUtil;

public class MobileDAOImpl implements MobileDAO {
	private SessionFactory factory = SFUtil.getFactory();
	Transaction trans = null;

	@Override
	public int save(MobileEntity entity) {
		int key = 0;
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			key = (int) session.save(entity);
			session.flush();
			session.clear();

			trans.commit();
			return key;
		}
	}

	@Override
	public void read(int id) {
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("from com.xworkz.mobile.entity.MobileEntity");
			List<MobileEntity> list = query.list();
			for (MobileEntity mobileEntity : list) {
				System.out.println(mobileEntity);
			}
		}
	}
}
