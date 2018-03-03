package com.ourteam.pcd.Configurations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateSessionFactoryManager {
	AnnotationConfiguration cfg2;
	SessionFactory factory;
	Session session;
	Transaction t;
	public HibernateSessionFactoryManager() {
		cfg2 = new AnnotationConfiguration();
		cfg2.configure("hibernate-mysql.cfg.xml");
		factory=cfg2.buildSessionFactory();
	}
	public Session getSession() {
		session = factory.openSession();
		t = session.beginTransaction();
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
