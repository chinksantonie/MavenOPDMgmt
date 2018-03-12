package com.pckg.opd;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pckg.opd.hibernate.Credentials;


public class CredentialsHibModel 
{
	SessionFactory factory;
	public CredentialsHibModel() 
	{
		// TODO Auto-generated constructor stub
		Configuration config=new Configuration().configure();
		factory=config.buildSessionFactory();
	}
	public boolean check(Credentials cred)
	{
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		Criteria criteria=session.createCriteria(Credentials.class);
		criteria.add(Restrictions.eq("username", cred.getUsername()));
		criteria.add(Restrictions.eq("password", cred.getPassword()));
		List<Credentials> credlist=criteria.list();
		System.out.println("Size"+credlist.size());
		if(credlist.size()==1)
		{
			return true;
		}
		return false;

	}
}
