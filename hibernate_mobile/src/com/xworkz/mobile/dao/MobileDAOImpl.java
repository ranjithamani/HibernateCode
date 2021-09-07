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
	public void readAllRecords() {
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("from com.xworkz.mobile.entity.MobileEntity");
			List<MobileEntity> list = query.list();
			for (MobileEntity mobileEntity : list) {
				System.out.println(mobileEntity);
			}
		}
	}

	@Override
	public double findMobilePriceByBrand(String brand) {
		double mobilePrice = 0;
		try (Session session = factory.openSession()) {
			Query query = session
					.createQuery("select mobile.price from MobileEntity mobile where mobile.brand='+brand+'");
			Object object = query.uniqueResult();
			if (object != null) {
				mobilePrice = (double) object;
			}
		}
		return mobilePrice;
	}

	@Override
	public double findTotalPrice() {
		double mobilePrice = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select sum(price) from MobileEntity");
			Object object = query.uniqueResult();
			if (object != null) {
				mobilePrice = (double) object;
			}
		}
		return mobilePrice;
	}

	@Override
	public double findMaxPrice() {
		double mobilePrice = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select max(price) from MobileEntity");
			Object object = query.uniqueResult();
			if (object != null) {
				mobilePrice = (double) object;
			}
		}
		return mobilePrice;
	}

	@Override
	public double findMinPrice() {
		double mobilePrice = 0;
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("select min(price) from MobileEntity");
			Object object = query.uniqueResult();
			if (object != null) {
				mobilePrice = (double) object;
			}
		}
		return mobilePrice;
	}

	@Override
	public void updatePriceByColor() {
		try (Session session = factory.openSession()) {
			Query query = session
					.createQuery("update MobileEntity mobile set mobile.price='75000.0'where mobile.color='Red'");
			session.beginTransaction();
			query.executeUpdate();
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteRowById() {
		try (Session session = factory.openSession()) {
			Query query = session.createQuery("delete MobileEntity  mobile where mobile.id=1");
			session.beginTransaction();
			query.executeUpdate();
			session.getTransaction().commit();
		}
	}
}
