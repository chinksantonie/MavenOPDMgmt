package com.pckg.opd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pckg.opd.dao.PatientDetailsDao;
import com.pckg.opd.hibernate.PatientDetails;
import com.pckg.opd.hibernate.PaymentDetails;
import com.pckg.opd.service.EmployeeDetailsService;
import com.pckg.opd.validators.PatientDetailsValidator;

@Controller
@RequestMapping("/*")
public class PatientController
{
	@Autowired
	private PatientDetailsDao patientDetailsDao;
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value="/patientsearch")
	public ModelAndView registration()
	{
		return new ModelAndView("patientsearch","patientsearch",new PatientDetails());
	}
	
	@RequestMapping(value="/patientdetails")
	public ModelAndView searchPatient(@ModelAttribute("patientdetails") @Valid PatientDetails patientdetails, BindingResult result, ModelMap model)
	{
		return new ModelAndView("patientdetails","patientDetails",patientDetailsDao.getSearchPatients(patientdetails));
	}
	
	@RequestMapping(value="/patientform")
	public ModelAndView addPatient()
	{
		
		return new ModelAndView("patientform","patientDetails",new PatientDetails());
	}
	
	@RequestMapping(value="/insertPatient")
	public ModelAndView insertPatient(@ModelAttribute("patientDetails") @Valid PatientDetails patientDetails, BindingResult result, ModelMap model)
	{
		new PatientDetailsValidator().validate(patientDetails, result);
		
		if(result.hasErrors())
		{
			return new ModelAndView("patientform","patientDetails",patientDetails);
		}
		else
		{
			patientDetailsDao.save(patientDetails);
			return new ModelAndView("patientsuccess","patientDetails",patientDetails);
		}
	}
	
	// show user
	@RequestMapping(value = "/editpatient/{id}")
	public ModelAndView showUser(@PathVariable("id") int id, Model model) 
	{
		
		PatientDetails patientDetails=patientDetailsDao.getPatientById(id);
		
		return new ModelAndView("patientform","patientDetails",patientDetails);

	}
	@RequestMapping(value="/addconsultant/{id}")
	public ModelAndView addConsultant(@PathVariable("id") int id, Model model)
	{
		PatientDetails patientDetails=patientDetailsDao.getPatientById(id);
		List<String> doctors = employeeDetailsService.getDoctors();
		ModelAndView modelAndView = new ModelAndView("addconsultant");
		modelAndView.addObject("patientID",patientDetails.getPatient_det_no());
		modelAndView.addObject("doctors",doctors);
		modelAndView.addObject("paymentDetails",new PaymentDetails());
		return modelAndView;
	}
	

}
