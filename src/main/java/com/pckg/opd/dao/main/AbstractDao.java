package com.pckg.opd.dao.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDao 
{

	private static final Configuration config;
	private static final SessionFactory sessionFactory;
	
	static
	{
		config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}

	protected Session getSession() 
	{
		
		return sessionFactory.openSession();
	}
}
