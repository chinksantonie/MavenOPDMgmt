package com.pckg.opd.validators;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pckg.opd.hibernate.Credentials;

@Component
public class CredentialsValidator implements Validator 
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return Credentials.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) 
	{
		ValidationUtils.rejectIfEmpty(err, "username", "cred.username.empty");
	    ValidationUtils.rejectIfEmpty(err, "password", "cred.password.empty");

	}

}
