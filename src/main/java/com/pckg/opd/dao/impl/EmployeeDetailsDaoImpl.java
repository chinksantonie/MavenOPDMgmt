package com.pckg.opd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pckg.opd.constants.EmployeeConstants;
import com.pckg.opd.dao.EmployeeDetailsDao;
import com.pckg.opd.dao.main.AbstractDao;
import com.pckg.opd.hibernate.EmployeeDetails;

@Repository(value="empdetDao")
public class EmployeeDetailsDaoImpl extends AbstractDao implements EmployeeDetailsDao
{
	
	@Override
	public boolean setEmployeeDetails(EmployeeDetails employeeDetails)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("EmployeeID before save:"+ employeeDetails.getEmployee_Details_No());
		session.save(employeeDetails);
		System.out.println("EmployeeID after save:"+ employeeDetails.getEmployee_Details_No());
		transaction.commit();
		return true;
	}
	
	@Override
	public List getEmployeeFromCredential(String username, String password) 
	{
		Criteria criteria=getSession().createCriteria(EmployeeDetails.class, "employeeDetails");
		criteria.createAlias("employeeDetails.credentials", "credentials");
		criteria.add(Restrictions.eq("credentials.username", username));
		criteria.add(Restrictions.eq("credentials.password", password));
	    ProjectionList projList = Projections.projectionList();
	    projList.add(Projections.property("employeeDetails.job_type"));
	    criteria.setProjection(projList);
		List employeeType=criteria.list();
		return employeeType;
		
	}
	@Override
	public List getDoctorLastName(String firstname)
	{
		Criteria criteria=getSession().createCriteria(EmployeeDetails.class,"employeeDetails");
		criteria.add(Restrictions.eq("first_Name",firstname));
		List lastName=criteria.list();
		if(criteria.list().size()==1)
		{
			return lastName;
		}
		return null;
		
	}
	/*
	 * 
	 * OPTION -1
	 * Criteria c = session.createCriteria(Dokument.class, "dokument");
c.createAlias("dokument.role", "role"); // inner join by default
c.createAlias("role.contact", "contact");
c.add(Restrictions.eq("contact.lastName", "Test"));
return c.list();

OPTION - 2
Criteria criteria = session.createCriteria(Student.class);
criteria.setFetchMode("Contact", FetchMode.JOIN).add(
		Restrictions.eq("id", 2));
List list = criteria.list();

Criteria cr = session.createCriteria(User.class)
.setProjection(Projections.projectionList()
  .add(Projections.property("id"), "id")
  .add(Projections.property("Name"), "Name"))
.setResultTransformer(Transformers.aliasToBean(User.class));

List<User> list = cr.list();
	 */

	@Override
	public List<EmployeeDetails> getAll() 
	{
		Criteria criteria=getSession().createCriteria(EmployeeDetails.class);
		List<EmployeeDetails> employeeDetails =criteria.list();
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllDoctors() 
	{
		Criteria criteria=getSession().createCriteria(EmployeeDetails.class);
		criteria.add(Restrictions.eq("job_type", EmployeeConstants.DOCTOR));
		List<EmployeeDetails> employeeDetails =criteria.list();
		return employeeDetails;
	}


}
