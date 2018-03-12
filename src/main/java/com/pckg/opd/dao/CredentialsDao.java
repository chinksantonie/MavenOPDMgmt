package com.pckg.opd.dao;

import java.util.List;

import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;

public interface CredentialsDao 
{
	public List<Credentials> getCredWithUnameAndPwd(String username,String password);
	public Credentials createCredentials(EmployeeDetails employeeDetails);
}

