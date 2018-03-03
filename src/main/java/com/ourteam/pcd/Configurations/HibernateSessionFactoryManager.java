package com.ourteam.pcd.Configurations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryManager {
	private static Configuration cfg2;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction t;
	static {
		cfg2 = new Configuration();
		cfg2.configure("hibernate-mysql.cfg.xml");
		factory=cfg2.buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	public static void setFactory(SessionFactory factory) {
		HibernateSessionFactoryManager.factory = factory;
	}
	
	
	
}
