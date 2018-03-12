package com.pckg.opd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pckg.opd.hibernate.PaymentDetails;

public class PaymentDetailsHibModel 
{
	public static void main(String[] args)
	{
		SessionFactory factory;
		Configuration config=new Configuration().configure();
		factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		PaymentDetails paymentdet=new PaymentDetails();
		
		
	}
}
