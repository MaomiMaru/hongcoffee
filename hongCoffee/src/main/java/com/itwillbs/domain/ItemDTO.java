package com.itwillbs.domain;

public class ItemDTO {

	private int item_num; //재료 번호 PK, AUTO_INCREMENT
	private String item_name; //재료명
	private int item_type; //유형
	private int item_price; //단가
	private int item_state; //재료 상태
	private String item_note; //물품 적요
	
	
	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}

	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_note() {
		return item_note;
	}
	public void setItem_note(String item_note) {
		this.item_note = item_note;
	}
	
	
}
