package com.pckg.opd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pckg.opd.dao.CredentialsDao;
import com.pckg.opd.hibernate.Credentials;
import com.pckg.opd.hibernate.EmployeeDetails;
import com.pckg.opd.service.EmployeeDetailsService;
import com.pckg.opd.validators.EmployeeDetailsValidator;

@Controller
@RequestMapping("/*")
public class EmployeeDetailsController 
{
	@Autowired
	private EmployeeDetailsService empdetService;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public ModelAndView registration()
	{
		return new ModelAndView("registration","employeeDetails",new EmployeeDetails());
	}
	
	@RequestMapping(value="/insertEmployee",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute("employeeDetails") @Valid EmployeeDetails employeeDetails, BindingResult result, ModelMap model)
	{
		new EmployeeDetailsValidator().validate(employeeDetails, result);
		if(result.hasErrors())
		{
			return registration();
		}
		String firstname=employeeDetails.getFirst_Name();
		System.out.println("firstname"+firstname);
		Credentials credentials = credentialsDao.createCredentials(employeeDetails);
		employeeDetails.setCredentials(credentials);
		boolean isInserted = empdetService.isInserted(employeeDetails);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registrationsuccess");
		modelAndView.addObject("employeeDetails",employeeDetails);
		modelAndView.addObject("credentials",credentials);
		
		
		return modelAndView;
	}
}
