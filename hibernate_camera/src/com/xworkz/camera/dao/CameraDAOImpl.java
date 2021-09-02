package com.xworkz.camera.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.camera.entity.CameraEntity;
import com.xworkz.camera.util.SFUtil;

public class CameraDAOImpl implements CameraDAO {

	private SessionFactory factory = SFUtil.getFactory();
	Transaction trans = null;

	@Override
	public int save(CameraEntity entity) {
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

	@Override
	public CameraEntity readById(int primaryKey) {
		try (Session session = factory.openSession()) {
			CameraEntity entity = session.get(CameraEntity.class, primaryKey);
			return entity;
		}
	}

	@Override
	public void updateBrandById(int id, String brand) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			CameraEntity entity = session.get(CameraEntity.class, id);
			entity.setBrand(brand);
			session.update(entity);
			trans.commit();
			System.out.println("updated:" + entity);

		} catch (Exception e) {
			
			trans.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int id) {

		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			CameraEntity entity = session.get(CameraEntity.class, id);
			session.delete(entity);
			trans.commit();
			System.out.println("deleted:" + entity);

		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void saveList(List<CameraEntity> entity) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			entity.forEach(r -> {
				session.save(r);
				System.out.println(r);

			});
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deleteList(List<CameraEntity> entity) {
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			entity.forEach(r -> {
				session.delete(r);
				System.out.println(r);

			});
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
