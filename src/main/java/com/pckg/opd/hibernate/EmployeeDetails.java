package com.pckg.opd.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_Details_No;
	private String first_Name;
	private String middle_Name;
	private String last_Name;
	private String houseName;
	private String street;
	private String city;
	private String pincode;
	/*@Embedded
	private EmployeeAddress empaddr;*/
	
    private String job_type;
    
	@OneToOne
	private Credentials credentials;

	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getEmployee_Details_No() {
		return employee_Details_No;
	}
	public void setEmployee_Details_No(int employee_Details_No) {
		this.employee_Details_No = employee_Details_No;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getMiddle_Name() {
		return middle_Name;
	}
	public void setMiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	

	
}
