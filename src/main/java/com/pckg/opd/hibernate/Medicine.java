package com.pckg.opd.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicine_no;
	private String medicine_slno;
	private String medicine_Name;
	private int no_of_strips;
	private float price_per_Strip;
	public int getMedicine_no() {
		return medicine_no;
	}
	public void setMedicine_no(int medicine_no) {
		this.medicine_no = medicine_no;
	}
	public String getMedicine_slno() {
		return medicine_slno;
	}
	public void setMedicine_slno(String medicine_slno) {
		this.medicine_slno = medicine_slno;
	}
	public String getMedicine_Name() {
		return medicine_Name;
	}
	public void setMedicine_Name(String medicine_Name) {
		this.medicine_Name = medicine_Name;
	}
	public int getNo_of_strips() {
		return no_of_strips;
	}
	public void setNo_of_strips(int no_of_strips) {
		this.no_of_strips = no_of_strips;
	}
	public float getPrice_per_Strip() {
		return price_per_Strip;
	}
	public void setPrice_per_Strip(float price_per_Strip) {
		this.price_per_Strip = price_per_Strip;
	}

	
}
