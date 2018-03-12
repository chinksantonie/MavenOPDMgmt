package com.pckg.opd.dao;

import java.util.List;

import com.pckg.opd.hibernate.PatientDetails;

public interface PatientDetailsDao 
{
	public boolean save(PatientDetails patientDetails);
	public List<PatientDetails> getAll();
	public List<PatientDetails> getSearchPatients(PatientDetails patientDetails);
	public PatientDetails getPatientById(int id);
	
}
