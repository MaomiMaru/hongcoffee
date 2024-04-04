package com.itwillbs.domain;

import java.sql.Timestamp;

public class ResultDTO {

	private int rs_num;//실적 번호
	private int num;//지점번호
	private int prod_num;//상품번호
	private int item_num;//재료번호
	private Timestamp rs_date; //영업일
	private int sales;//판매량
	private int consume;//판매량
	private int maechul; //매출
	private int jichul; //지출
	private int income; //순수익
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getConsume() {
		return consume;
	}
	public void setConsume(int consume) {
		this.consume = consume;
	}
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
	public int getMaechul() {
		return maechul;
	}
	public void setMaechul(int maechul) {
		this.maechul = maechul;
	}
	public int getJichul() {
		return jichul;
	}
	public void setJichul(int jichul) {
		this.jichul = jichul;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}

	
	
	
	
}
