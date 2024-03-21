package com.itwillbs.domain;

import java.sql.Timestamp;

public class ResultDTO {

	private int rs_num;//실적 번호
	private int num;//지점번호
	private int prod_num;//상품번호
	private int item_num;//재료번호
	private Timestamp rs_date; //영업일
	private int re_amount;//판매량/소모량
	private String rs_note;//실적 적요
	
	public int getRs_num() {
		return rs_num;
	}
	public void setRs_num(int rs_num) {
		this.rs_num = rs_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getRe_amount() {
		return re_amount;
	}
	public void setRe_amount(int re_amount) {
		this.re_amount = re_amount;
	}
	public String getRs_note() {
		return rs_note;
	}
	public void setRs_note(String rs_note) {
		this.rs_note = rs_note;
	}
	public Timestamp getRs_date() {
		return rs_date;
	}
	public void setRs_date(Timestamp rs_date) {
		this.rs_date = rs_date;
	}

	
	
	
	
}
