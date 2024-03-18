package com.itwillbs.domain;

import java.sql.Timestamp;

public class ResultDTO {

	private Timestamp rs_date; //영업일
	private int income; //수입
	
	public Timestamp getRs_date() {
		return rs_date;
	}
	public void setRs_date(Timestamp rs_date) {
		this.rs_date = rs_date;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
	
	
	
}
