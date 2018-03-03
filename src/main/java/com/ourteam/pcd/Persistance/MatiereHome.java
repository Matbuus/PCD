package com.ourteam.pcd.Persistance;
// Generated Mar 3, 2018 1:38:40 PM by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.ourteam.pcd.Configurations.HibernateSessionFactoryManager;
import com.ourteam.pcd.Entity.Matiere;

/**
 * Home object for domain model class Matiere.
 * @see com.ourteam.pcd.Persistance.Matiere
 * @author Hibernate Tools
 */
public class MatiereHome {

	private static final Log log = LogFactory.getLog(MatiereHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateSessionFactoryManager.getFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Matiere transientInstance) {
		log.debug("persisting Matiere instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Matiere instance) {
		log.debug("attaching dirty Matiere instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Matiere instance) {
		log.debug("attaching clean Matiere instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Matiere persistentInstance) {
		log.debug("deleting Matiere instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Matiere merge(Matiere detachedInstance) {
		log.debug("merging Matiere instance");
		try {
			Matiere result = (Matiere) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Matiere findById(java.lang.String id) {
		log.debug("getting Matiere instance with id: " + id);
		try {
			Matiere instance = (Matiere) sessionFactory.getCurrentSession().get("com.ourteam.pcd.Persistance.Matiere",
					id);
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

	public List findByExample(Matiere instance) {
		log.debug("finding Matiere instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.ourteam.pcd.Persistance.Matiere")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
