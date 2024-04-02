package com.itwillbs.domain;

public class StockDTO {
	
	private int stock_num; //물품번호 PK,FK(item테이블 참조)
	private int num; //지점 번호(
	private int item_num;
	private String item_name; //물품명
	private String item_type; //유형
	private int amount; //보유량
	private int item_price; //단가
	private String stock_note; //재고 적요
	private int item_state; //재료상태


	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}
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
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	
	

}
