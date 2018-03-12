package com.pckg.opd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pckg.opd.constants.EmployeeConstants;
import com.pckg.opd.dao.PatientDetailsDao;
import com.pckg.opd.dao.PaymentDetailsDao;
import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;
import com.pckg.opd.hibernate.PatientDetails;
import com.pckg.opd.hibernate.PaymentDetails;
import com.pckg.opd.service.CredentialsService;
import com.pckg.opd.service.EmployeeDetailsService;
import com.pckg.opd.validators.CredentialsValidator;


@Controller
@RequestMapping("/*")
public class CredentialsController 
{	
	@Autowired
	private CredentialsService credentialsService;
	
	@Autowired
	private EmployeeDetailsService employeeService;
	
	@Autowired
	private PatientDetailsDao patientDetailsDao;
	
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	
	@RequestMapping(value="/login")//,method=RequestMethod.GET)
	public ModelAndView login()
	{
		return new ModelAndView("login","logindata",new Credentials());
	}
	
	@RequestMapping(value="/authorize")//,method=RequestMethod.POST)
	public ModelAndView authorize(@ModelAttribute("logindata") @Valid Credentials logindata, BindingResult result, ModelMap model)
	{
		new CredentialsValidator().validate(logindata, result);
		if (result.hasErrors())
		{
			return login();
		}
		String username=logindata.getUsername();
		String password=logindata.getPassword();
		
		boolean isAdminUser = credentialsService.isAdmin(username, password);
		System.out.println("isAdminUser:"+isAdminUser);
		if(isAdminUser)
		{
			return new ModelAndView("registration","employeeDetails",new EmployeeDetails());
		}
		
		boolean isAuthorized = credentialsService.isAuthorized(username, password);
		System.out.println("isAuthorized:"+isAuthorized);
		if (isAuthorized)
		{
			String employeeType = employeeService.getEmployeeTypeCredential(username, password);
			System.out.println("employeeType:"+employeeType);
	
			String displayPage = null;
			if (EmployeeConstants.DOCTOR.equals(employeeType))
			{
				List <String> doctorfullname=employeeService.getDoctorsFullName(username);
				System.out.println("doctorfullname"+doctorfullname);
				List<PatientDetails> patientId=paymentDetailsDao.getPatient(doctorfullname);
				//System.out.println("patientId"+patientId.get(0).toString());
				return new ModelAndView("specificpatients","doctorspatients",new PatientDetails());
			}
			else if (EmployeeConstants.RECEPTIONIST.equals(employeeType))
			{
				return new ModelAndView("patientsearch","patientsearch",new PatientDetails());
				//return new ModelAndView("patientdetails","patientDetails",patientDetailsDao.getAll());
				
			}
			else
			{
				displayPage = "invalidPage";
			}

				
			return new ModelAndView("registration","employeeDetails",new EmployeeDetails());
			//return new ModelAndView(displayPage,"credpojo",cred);
		}
		else
		{
			result.reject("cred.usernamepwd.invalid");
			//result.rejectValue("title", "book.title.invalid");
			return login();
		}
		
	}
	
	
}
