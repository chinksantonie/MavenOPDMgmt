package com.pckg.opd.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pckg.opd.hibernate.EmployeeDetails;

@Component
public class EmployeeDetailsValidator implements Validator 
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return EmployeeDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) 
	{
		ValidationUtils.rejectIfEmpty(err, "first_Name", "employeeDetails.first_Name.empty");
	    ValidationUtils.rejectIfEmpty(err, "houseName", "employeeDetails.houseName.empty");
		
	}
	
}
