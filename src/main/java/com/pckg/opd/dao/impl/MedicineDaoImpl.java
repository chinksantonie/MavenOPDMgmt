package com.pckg.opd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pckg.opd.dao.MedicineDao;
import com.pckg.opd.dao.main.AbstractDao;
import com.pckg.opd.hibernate.Medicine;

@Repository(value="medicineDao")
public class MedicineDaoImpl extends AbstractDao implements MedicineDao 
{
	@Override
	public List<Medicine> getMedicineList(Medicine medicine)
	{
		
		Criteria criteria=getSession().createCriteria(Medicine.class);
		/*String medicine_slno=
		private int medicine_no;
		private String medicine_slno;
		private String medicine_Name;
		private int no_of_strips;
		private float price_per_Strip;*/
		List<Medicine> medicinelist =criteria.list();
		return medicinelist;
		
	}
}
