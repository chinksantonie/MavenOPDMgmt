package com.pckg.opd.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import com.pckg.opd.hibernate.Medicine;

import com.pckg.opd.dao.MedicineDao;

@Controller
@RequestMapping("/*")
public class MedicineController 
{
	@Autowired
	MedicineDao medicineDao;
	
	@RequestMapping(value="/showmedicine",method=RequestMethod.GET)
	public ModelAndView showmedicine()
	{
		return null;
		/*List<Medicine> medicinelist=medicineDao.getMedicineList(Medicine medicine);
		System.out.println("No of rows"+medicinelist.size());
		return new ModelAndView("showmedicine","medicine",medicinelist);*/
	}
}
