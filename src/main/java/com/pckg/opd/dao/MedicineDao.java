package com.pckg.opd.dao;

import java.util.List;

import com.pckg.opd.hibernate.Medicine;

public interface MedicineDao 
{
	public List<Medicine> getMedicineList(Medicine medicine);
}
