package com.mindtree.evtmanagement.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mindtree.evtmanagement.exception.SystemException;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		
		try{
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry registry = new StandardServiceRegistryBuilder().build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
			return sessionFactory;
		}catch(Exception e){
			
			throw new SystemException(e,"Unable to initialize the session factory");
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
