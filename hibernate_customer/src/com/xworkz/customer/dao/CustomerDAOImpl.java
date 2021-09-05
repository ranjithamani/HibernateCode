package com.xworkz.customer.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.customer.entity.CustomerEntity;
import com.xworkz.customer.util.SFUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private SessionFactory factory = SFUtil.getFactory();
	Transaction trans = null;

	@Override
	public int save(CustomerEntity entity) {
		int key = 0;
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			key = (int) session.save(entity);
			session.flush();
			session.clear();

			trans.commit();
			System.out.println(key);

		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public CustomerEntity readById(int primaryKey) {
		try (Session session = factory.openSession()) {
			CustomerEntity entity = session.get(CustomerEntity.class, primaryKey);
			return entity;
		}
	}

	@Override
	public void updateNameById(int id, String name) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			CustomerEntity entity = session.get(CustomerEntity.class, id);
			entity.setName(name);
			session.update(entity);
			trans.commit();

		} catch (Exception e) {

			trans.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void saveList(List<CustomerEntity> entity) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			
			AtomicInteger atomicInteger=new AtomicInteger(0);
			entity.forEach(r -> {
		CustomerEntity customer=session.load(CustomerEntity.class,r.getId());
		if(customer!= null) {
		     session.save(r);
		     System.out.println(r);
		}
	   if (atomicInteger.incrementAndGet() % 10 == 0) {
				session.flush();
		    }
		    
			});
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}
	@Override
	public CustomerEntity loadById(int id) {
		try (Session session = factory.openSession()) {
			CustomerEntity entity = session.load(CustomerEntity.class, id);
		return entity;
	}
	
}
}

