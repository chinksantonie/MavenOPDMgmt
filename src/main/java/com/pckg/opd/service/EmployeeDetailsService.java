package com.pckg.opd.service;

import java.util.List;

import com.pckg.opd.hibernate.EmployeeDetails;

public interface EmployeeDetailsService 
{
	public String getEmployeeTypeCredential(String username, String password);
	public boolean isInserted(EmployeeDetails employeeDetails);
	public List<String> getDoctors();
	public List<String> getDoctorsFullName(String firstname);
}
