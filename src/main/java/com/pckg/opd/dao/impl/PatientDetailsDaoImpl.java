package com.pckg.opd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pckg.opd.dao.PatientDetailsDao;
import com.pckg.opd.dao.main.AbstractDao;
import com.pckg.opd.hibernate.PatientDetails;

@Repository(value="patdetDao")
public class PatientDetailsDaoImpl extends AbstractDao implements PatientDetailsDao
{

	@Override
	public boolean save(PatientDetails patientDetails) 
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Patient before save:"+ patientDetails);
		session.saveOrUpdate(patientDetails);
		System.out.println("Patient after save:"+ patientDetails);
		transaction.commit();
		
		return true;
		
	}

	@Override
	public List<PatientDetails> getAll() 
	{
		Criteria criteria=getSession().createCriteria(PatientDetails.class);
		List<PatientDetails> patientDetails =criteria.list();
		return patientDetails;
	}

	@Override
	public List<PatientDetails> getSearchPatients(PatientDetails patientDetails) 
	{
		Criteria criteria=getSession().createCriteria(PatientDetails.class);
		int patient_det_no = patientDetails.getPatient_det_no();
		String first_Name = patientDetails.getFirst_Name();
		String last_Name = patientDetails.getLast_Name();
		String houseName=patientDetails.getHouseName();
		System.out.println("Search criteria:"+ patient_det_no+","+first_Name+","+last_Name);
		
		if (patient_det_no!=0)
		{
			criteria.add(Restrictions.eq("patient_det_no", patient_det_no));
		}
		if (first_Name!=null && !"".equals(first_Name))
		{
			criteria.add(Restrictions.like("first_Name", first_Name, MatchMode.START));

		}
		if (last_Name!=null && !"".equals(last_Name))
		{
			criteria.add(Restrictions.like("last_Name", last_Name, MatchMode.START));
		}
		if (houseName!=null && !"".equals(houseName))
		{
			criteria.add(Restrictions.like("houseName", houseName, MatchMode.START));
		}
		criteria.addOrder(Order.desc("patient_det_no"));
		List<PatientDetails> patientResult =criteria.list();
		return patientResult;
	}
	
	@Override
	public PatientDetails getPatientById(int id) 
	{
		Criteria criteria=getSession().createCriteria(PatientDetails.class);
		criteria.add(Restrictions.eq("patient_det_no", id));
		List<PatientDetails> patientResult =criteria.list();
		if (patientResult.size() == 1)
		{
			return patientResult.get(0);
		}
		return null;
	}
}
