package org.renting.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration configuration;
	private final static SessionFactory sessionFactory;
	
	//初始化Configuration和SessionFactory
	static{
		try {
			configuration=new Configuration().configure();
			sessionFactory=configuration.buildSessionFactory();
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private HibernateUtil(){}
	
	//获取Session对象
	public static Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
