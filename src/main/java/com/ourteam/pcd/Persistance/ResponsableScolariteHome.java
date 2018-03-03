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
import com.ourteam.pcd.Entity.ResponsableScolarite;

/**
 * Home object for domain model class ResponsableScolarite.
 * @see com.ourteam.pcd.Persistance.ResponsableScolarite
 * @author Hibernate Tools
 */
public class ResponsableScolariteHome {

	private static final Log log = LogFactory.getLog(ResponsableScolariteHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateSessionFactoryManager.getFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ResponsableScolarite transientInstance) {
		log.debug("persisting ResponsableScolarite instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ResponsableScolarite instance) {
		log.debug("attaching dirty ResponsableScolarite instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResponsableScolarite instance) {
		log.debug("attaching clean ResponsableScolarite instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ResponsableScolarite persistentInstance) {
		log.debug("deleting ResponsableScolarite instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ResponsableScolarite merge(ResponsableScolarite detachedInstance) {
		log.debug("merging ResponsableScolarite instance");
		try {
			ResponsableScolarite result = (ResponsableScolarite) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ResponsableScolarite findById(java.lang.String id) {
		log.debug("getting ResponsableScolarite instance with id: " + id);
		try {
			ResponsableScolarite instance = (ResponsableScolarite) sessionFactory.getCurrentSession()
					.get("com.ourteam.pcd.Persistance.ResponsableScolarite", id);
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

	public List findByExample(ResponsableScolarite instance) {
		log.debug("finding ResponsableScolarite instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.ourteam.pcd.Persistance.ResponsableScolarite").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
