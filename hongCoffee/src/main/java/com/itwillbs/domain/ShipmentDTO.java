package com.itwillbs.domain;

import java.sql.Timestamp;

public class ShipmentDTO {
	
	private String name;
	private String item_name;
	private int item_price;
	private String sh_note;
	private int od_num;
	private int num;
	private int item_num;
	private int sh_amount;
	private String sh_time;
	
	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	
	public int getOd_num() {
		return od_num;
	}
	
	public void setOd_num(int od_num) {
		this.od_num = od_num;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getSh_amount() {
		return sh_amount;
	}
	
	public void setSh_amount(int sh_amount) {
		this.sh_amount = sh_amount;
	}
	
	public String getSh_time() {
		return sh_time;
	}
	
	public void setSh_time(String sh_time) {
		this.sh_time = sh_time;
	}
	
	public String getSh_note() {
		return sh_note;
	}
	
	public void setSh_note(String sh_note) {
		this.sh_note = sh_note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "ShipmentDTO [name=" + name + ", item_name=" + item_name + ", item_price=" + item_price + ", sh_note="
				+ sh_note + ", od_num=" + od_num + ", num=" + num + ", item_num=" + item_num + ", sh_amount="
				+ sh_amount + ", sh_time=" + sh_time + "]";
	}
	
}
