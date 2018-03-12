package com.pckg.opd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pckg.opd.dao.CredentialsDao;
import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;
import com.pckg.opd.service.CredentialsService;

@Service
public class CredentialsServiceImpl implements CredentialsService 
{
	
	@Autowired
	private CredentialsDao credentialsDao;

	@Override
	public boolean isAuthorized(String username, String password) 
	{
		List<Credentials> credentials= credentialsDao.getCredWithUnameAndPwd(username, password);
		if(credentials.size()==1)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isAdmin(String username, String password)
	{
		boolean isAdminUser = "admin".equals(username) && "admin".equals(password);
		return isAdminUser;
	}
	
}
