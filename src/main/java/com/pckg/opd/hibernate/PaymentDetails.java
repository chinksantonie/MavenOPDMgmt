package com.pckg.opd.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class PaymentDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_no;
	private int doctor_no;
	private String doctorName;
	private int consultation_Fees;
	private String payment_Status;
	
	@Transient
	private int patientID;
	
	@OneToOne
	private PatientDetails patientDetails;
	
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getDoctor_no() {
		return doctor_no;
	}
	public void setDoctor_no(int doctor_no) {
		this.doctor_no = doctor_no;
	}
	public int getConsultation_Fees() {
		return consultation_Fees;
	}
	public void setConsultation_Fees(int consultation_Fees) {
		this.consultation_Fees = consultation_Fees;
	}
	public String getPayment_Status() {
		return payment_Status;
	}
	public void setPayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}
	
	@Override
	public String toString()
	{
		return "payment_no:"+payment_no+
				";doctor_no:"+doctor_no+
				";doctorName:"+doctorName+
				";consultation_Fees:"+consultation_Fees+
				";payment_Status:"+payment_Status+
				";patientID:"+patientID;
	}
	
}
