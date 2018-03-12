package com.pckg.opd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pckg.opd.dao.PatientDetailsDao;
import com.pckg.opd.dao.PaymentDetailsDao;
import com.pckg.opd.dao.main.AbstractDao;
import com.pckg.opd.hibernate.PatientDetails;
import com.pckg.opd.hibernate.PaymentDetails;

@Repository(value="paydetDao")
public class PaymentDetailsDaoImpl extends AbstractDao implements PaymentDetailsDao
{
	@Autowired
	private PatientDetailsDao patientDetailsDao;

	@Override
	public void save(PaymentDetails paymentDetails) 
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("paymentDetails before save:"+ paymentDetails);
		paymentDetails.setPatientDetails(patientDetailsDao.getPatientById(paymentDetails.getPatientID()));
		session.save(paymentDetails);
		System.out.println("paymentDetails after save:"+ paymentDetails);
		transaction.commit();
	}

	@Override
	public List<PaymentDetails> getAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<PaymentDetails> getPatient(List<String> doctorname)
	{
		Criteria criteria=getSession().createCriteria(PaymentDetails.class);
		criteria.add(Restrictions.eq("doctorName",doctorname));
		List<PaymentDetails> patientId =criteria.list();
		System.out.println(criteria.list());
		if (patientId.size() == 1)
		{
			return patientId;
		}
		return null;
	}*/
	@Override
	public List<PatientDetails> getPatient(List<String> doctorname)
	{
		String doctor=doctorname.get(0).toString();
		Criteria criteria=getSession().createCriteria(PaymentDetails.class);
		criteria.add(Restrictions.eq("doctorName",doctor));
		List<PaymentDetails> paymentDetails =criteria.list();
		System.out.println(criteria.list());
		List<PatientDetails> patientDetails=new ArrayList<>();
		for(PaymentDetails paymentDetail:paymentDetails)
		{
			patientDetails.add(paymentDetail.getPatientDetails());
		}
		return patientDetails;
	}
}
