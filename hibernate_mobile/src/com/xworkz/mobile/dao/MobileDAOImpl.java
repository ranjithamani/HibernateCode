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

	@Override
	public int save(MobileEntity entity) {
		int key = 0;
		try (Session session = factory.openSession()) {
			Transaction trans = session.beginTransaction();
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
			Query query = session.getNamedQuery("readAllRecords");
			List<MobileEntity> list = query.list();
			System.out.println(list);
		}
	}

	@Override
	public double findMobilePriceByBrand(String brand) {
		double mobilePrice = 0;
		try (Session session = factory.openSession()) {
			Query query = session.getNamedQuery("findMobilePriceByBrand");
			query.setParameter("Brand", brand);
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
			Query query = session.getNamedQuery("findTotalPrice");
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
			Query query = session.getNamedQuery("findMaxPrice");
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
			Query query = session.getNamedQuery("findMinPrice");
			Object object = query.uniqueResult();
			if (object != null) {
				mobilePrice = (double) object;
			}
		}
		return mobilePrice;
	}

	@Override
	public void updatePriceByColor(double price, String color) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();

			Query query = session.getNamedQuery("updatePriceByColor");
			query.setParameter("Price", price);
			query.setParameter("Color", color);

			int updatedprice = query.executeUpdate();
			System.out.println(updatedprice);
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteRowById(int id) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("deleteRowById");
			query.setParameter("Id", id);
			int deleted = query.executeUpdate();
			System.out.println(deleted);
			session.getTransaction().commit();
		}
	}
}
