package com.xworkz.bird.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFUtil {
	private static SessionFactory factory;

	public static SessionFactory getFactory() {

		return factory;
	}

	static {

		Configuration configure = new Configuration().configure();
		factory = configure.buildSessionFactory();

	}
}
