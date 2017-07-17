package com.hibernate.association.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.association.util.HibernateUtility;

public class EmployeeDAO {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = HibernateUtility.getSessionFactory();
	}

	public static <T> Object save(T entity) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(entity);

		session.getTransaction().commit();

		return entity;
	}

	public static <T> Object update(T entitye) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.merge(entitye);

		session.getTransaction().commit();

		return entitye;

	}

	public static <T> void delete(T entity) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.delete(entity);

		session.getTransaction().commit();

	}
}
