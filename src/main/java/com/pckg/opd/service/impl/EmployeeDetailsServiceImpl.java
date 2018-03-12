package com.pckg.opd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pckg.opd.dao.EmployeeDetailsDao;
import com.pckg.opd.hibernate.EmployeeDetails;
import com.pckg.opd.service.EmployeeDetailsService;

@Service("empdetService")
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService 
{

	@Autowired
	private EmployeeDetailsDao employeeDetailsDao;
	
	@Override
	public boolean isInserted(EmployeeDetails employeeDetails)
	{
		
		boolean isInserted= employeeDetailsDao.setEmployeeDetails(employeeDetails);
		return isInserted;
	}
	
	@Override
	public String getEmployeeTypeCredential(String username, String password) 
	{
		List employeeType = employeeDetailsDao.getEmployeeFromCredential(username, password);
		if(employeeType.isEmpty())
		{
			return null;
		}
		else
		{
			return employeeType.get(0).toString();
		}
	}

	@Override
	public List<String> getDoctors() 
	{
		List<EmployeeDetails> employeeDetails = employeeDetailsDao.getAllDoctors();
		List<String> doctors = new ArrayList<>();
		for (EmployeeDetails employee: employeeDetails)
		{
			doctors.add(employee.getFirst_Name()+" "+ employee.getLast_Name());
		}
		return doctors;
	}
	
	@Override
	public List<String> getDoctorsFullName(String firstname)
	{
		List<EmployeeDetails> employeeDetails=employeeDetailsDao.getDoctorLastName(firstname);
		List<String> doctorsfullname = new ArrayList<>();
		for (EmployeeDetails employee: employeeDetails)
		{
			doctorsfullname.add(employee.getFirst_Name()+" "+ employee.getLast_Name());
		}
		return doctorsfullname;
	}

}
