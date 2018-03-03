package com.ourteam.pcd.Persistance;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import com.ourteam.pcd.Configurations.HibernateSessionFactoryManager;
import com.ourteam.pcd.Entity.Compte;


public class CompteHome {

	private static final Log log = LogFactory.getLog(CompteHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateSessionFactoryManager.getFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Compte transientInstance) {
		log.debug("persisting Compte instance");
		sessionFactory.getCurrentSession().beginTransaction().begin();
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public void attachDirty(Compte instance) {
		log.debug("attaching dirty Compte instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compte instance) {
		log.debug("attaching clean Compte instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Compte persistentInstance) {
		log.debug("deleting Compte instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compte merge(Compte detachedInstance) {
		log.debug("merging Compte instance");
		try {
			Compte result = (Compte) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Compte findById(java.lang.String id) {
		log.debug("getting Compte instance with id: " + id);
		try {
			Compte instance = (Compte) sessionFactory.getCurrentSession().get("com.ourteam.pcd.Persistance.Compte", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Compte instance) {
		log.debug("finding Compte instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.ourteam.pcd.Persistance.Compte")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
