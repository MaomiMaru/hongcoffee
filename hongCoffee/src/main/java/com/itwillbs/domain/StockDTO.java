package com.itwillbs.domain;

import java.sql.Timestamp;

public class StockDTO {
	
	private int stock_num; //물품번호 PK,FK(item테이블 참조)
	private int num; //지점 번호(
	private String item_name; //물품명
	private String item_type; //유형
	private int amount; //보유량

	private String stock_note; //재고 적요
	

	public int getStock_num() {
		return stock_num;
	}
	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStock_note() {
		return stock_note;
	}
	public void setStock_note(String stock_note) {
		this.stock_note = stock_note;
	}
	
	

}
