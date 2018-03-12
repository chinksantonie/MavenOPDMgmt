package com.pckg.opd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pckg.opd.dao.PaymentDetailsDao;
import com.pckg.opd.hibernate.PaymentDetails;

@Controller
@RequestMapping("/*")
public class PaymentController
{
	
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	
	@RequestMapping(value="/saveconsultation")
	public ModelAndView saveConsultant(@ModelAttribute("paymentDetails") @Valid PaymentDetails paymentDetails, BindingResult result, ModelMap model)
	{
		System.out.println("paymentDetails:"+paymentDetails);
		paymentDetailsDao.save(paymentDetails);
		String paymentstatus=paymentDetails.getPayment_Status();
		if(paymentstatus.equals("Y"))
		{
			return new ModelAndView("paymentsuccess","paymentDetails",paymentDetails);
		}
		else
		{
			return new ModelAndView("paymentfail","paymentDetails",paymentDetails);
		}
	}
}
