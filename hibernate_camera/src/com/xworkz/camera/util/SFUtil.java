package com.xworkz.camera.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFUtil {
	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory != null && factory.isClosed()) {
			throw new IllegalStateException("some is closed the code ,please correct the code");
		}
		return factory;
	}

	static {
		try {
			Configuration configure = new Configuration().configure();
			factory = configure.buildSessionFactory();

		} catch (HibernateException e) {
			e.printStackTrace();

		}
	}

}
