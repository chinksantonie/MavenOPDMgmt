package com.pckg.opd.dao;

import java.util.List;

import com.pckg.opd.hibernate.EmployeeDetails;

public interface EmployeeDetailsDao 
{
	public List getEmployeeFromCredential(String username, String password);
	public boolean setEmployeeDetails(EmployeeDetails employeeDetails);
	public List<EmployeeDetails> getAll();
	public List<EmployeeDetails> getAllDoctors();
	public List<EmployeeDetails> getDoctorLastName(String firstname);
}
