package com.pckg.opd.service;

import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;

public interface CredentialsService 
{
	public boolean isAuthorized(String username, String password);
	public boolean isAdmin(String username, String password);

}
