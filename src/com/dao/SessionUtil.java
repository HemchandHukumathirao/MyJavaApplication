package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {

	static Session session = null;
	static SessionFactory factory = null;
	static {

		Configuration cfg = new Configuration().configure();
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(reg);

	}

	public static Session getSession() {
		session = factory.openSession();
		return session;
	}

	public static void closeSession() {
		if (session != null) {
			session.close();
		}
	}

}
