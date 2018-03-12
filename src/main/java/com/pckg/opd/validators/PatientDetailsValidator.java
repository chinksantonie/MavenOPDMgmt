package com.pckg.opd.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pckg.opd.hibernate.PatientDetails;

public class PatientDetailsValidator implements Validator 
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return PatientDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) 
	{
		ValidationUtils.rejectIfEmpty(err, "first_Name", "patientDetails.first_Name.empty");
	    ValidationUtils.rejectIfEmpty(err, "houseName", "patientDetails.houseName.empty");

	}

}
