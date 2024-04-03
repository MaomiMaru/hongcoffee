package com.itwillbs.domain;

import java.sql.Timestamp;

public class ResultDTO {

	private int rs_num;// 실적 번호
	private int num;// 지점번호
	private int prod_num;// 상품번호
	private int item_num;// 재료번호
	private int stock_num;// 재고번호
	private Timestamp rs_date; // 영업일
	private int sales;// 판매량
	private int consume;// 소모량
	private int consumeBefore;// 소모량
	private String item_name; // 재료명
	private int item_type; // 재료유형
	private int item_price; // 단가
	private int maechul; // 판매량 * 판매가 = 매출
	private int jichul; // 소모량 * 단가 = 소모가
	private int income; // 매출 - 소모가 = 순수익
	private String prod_name; // 상품명
	private int prod_price; // 판매가
	private String rs_note; // 적요

	public int getConsumeBefore() {
		return consumeBefore;
	}

	public void setConsumeBefore(int consumeBefore) {
		this.consumeBefore = consumeBefore;
	}

	public int getItem_type() {
		return item_type;
	}

	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
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

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

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

	public int getStock_num() {
		return stock_num;
	}

	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
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
