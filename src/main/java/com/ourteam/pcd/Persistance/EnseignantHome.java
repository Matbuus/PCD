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
import com.ourteam.pcd.Entity.Enseignant;

/**
 * Home object for domain model class Enseignant.
 * @see com.ourteam.pcd.Persistance.Enseignant
 * @author Hibernate Tools
 */
public class EnseignantHome {

	private static final Log log = LogFactory.getLog(EnseignantHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateSessionFactoryManager.getFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Enseignant transientInstance) {
		log.debug("persisting Enseignant instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Enseignant instance) {
		log.debug("attaching dirty Enseignant instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Enseignant instance) {
		log.debug("attaching clean Enseignant instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Enseignant persistentInstance) {
		log.debug("deleting Enseignant instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Enseignant merge(Enseignant detachedInstance) {
		log.debug("merging Enseignant instance");
		try {
			Enseignant result = (Enseignant) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Enseignant findById(java.lang.String id) {
		log.debug("getting Enseignant instance with id: " + id);
		try {
			Enseignant instance = (Enseignant) sessionFactory.getCurrentSession()
					.get("com.ourteam.pcd.Persistance.Enseignant", id);
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

	public List findByExample(Enseignant instance) {
		log.debug("finding Enseignant instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.ourteam.pcd.Persistance.Enseignant")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
