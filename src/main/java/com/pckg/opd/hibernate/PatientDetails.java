package com.pckg.opd.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class PatientDetails 
{
	  
	@TableGenerator(name = "PatientDetails_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "PatientDetails_Gen", initialValue = 10000, allocationSize = 100)  
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PatientDetails_Gen")
	private int patient_det_no;
	private String first_Name;
	private String middle_Name;
	private String last_Name;
	private String houseName;
	private String street;
	private String city;
	private String pincode;
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
	
	public int getPatient_det_no() {
		return patient_det_no;
	}
	public void setPatient_det_no(int patient_det_no) {
		this.patient_det_no = patient_det_no;
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
	
	@Override
	public String toString()
	{
		return "patient_det_no:"+patient_det_no+
				",first_Name:"+first_Name+
				",last_Name:"+last_Name;
	}

}
