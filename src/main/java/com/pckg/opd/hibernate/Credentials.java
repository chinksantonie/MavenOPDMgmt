package com.pckg.opd.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credentials 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cred_no;
	private String username;
	private String password;
	
	
	public int getCred_no() {
		return cred_no;
	}
	public void setCred_no(int cred_no) {
		this.cred_no = cred_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString()
	{
		return "cred_no"+cred_no+
				"username"+username+
				"password"+password;
	}
	
}
