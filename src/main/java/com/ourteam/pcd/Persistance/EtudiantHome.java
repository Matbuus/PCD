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
import com.ourteam.pcd.Entity.Etudiant;

/**
 * Home object for domain model class Etudiant.
 * @see com.ourteam.pcd.Persistance.Etudiant
 * @author Hibernate Tools
 */
public class EtudiantHome {

	private static final Log log = LogFactory.getLog(EtudiantHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateSessionFactoryManager.getFactory();		
			} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Etudiant transientInstance) {
		sessionFactory.getCurrentSession().beginTransaction().begin();
		log.debug("persisting Etudiant instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public void attachDirty(Etudiant instance) {
		log.debug("attaching dirty Etudiant instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Etudiant instance) {
		log.debug("attaching clean Etudiant instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Etudiant persistentInstance) {
		log.debug("deleting Etudiant instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Etudiant merge(Etudiant detachedInstance) {
		log.debug("merging Etudiant instance");
		try {
			Etudiant result = (Etudiant) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Etudiant findById(java.lang.String id) {
		log.debug("getting Etudiant instance with id: " + id);
		try {
			Etudiant instance = (Etudiant) sessionFactory.getCurrentSession()
					.get("com.ourteam.pcd.Persistance.Etudiant", id);
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

	public List findByExample(Etudiant instance) {
		log.debug("finding Etudiant instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.ourteam.pcd.Persistance.Etudiant")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
