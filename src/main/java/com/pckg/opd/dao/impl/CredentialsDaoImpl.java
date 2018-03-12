package com.pckg.opd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pckg.opd.dao.CredentialsDao;
import com.pckg.opd.dao.main.AbstractDao;
import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;

@Repository(value="credDao")
public class CredentialsDaoImpl extends AbstractDao implements CredentialsDao 
{
	
	@Override
	public List<Credentials> getCredWithUnameAndPwd(String username,String password)
	{
		Criteria criteria=getSession().createCriteria(Credentials.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<Credentials> credlist=criteria.list();
		return credlist;
	}
	
	public Credentials createCredentials(EmployeeDetails employeeDetails)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Credentials credentials = new Credentials();
		String firstname = employeeDetails.getFirst_Name();
		credentials.setUsername(firstname);
		credentials.setPassword(firstname);
		System.out.println("credentials before save:"+ credentials.getCred_no());
		session.save(credentials);
		System.out.println("credentials after save:"+ credentials.getCred_no());
		transaction.commit();
		return credentials;
	}
	
}
