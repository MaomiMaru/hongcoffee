package com.itwillbs.domain;

import java.sql.Timestamp;

public class ReceiveDTO {

	private int od_num; //거래번호
	private int num; //지점번호
	private int item_num; //물품번호
	private int rc_amount; //입고수량
	private Timestamp rc_time; //입고일시
	private String rc_note; //입고적요
	private String sh_note; //출하적요
	private int pay; //결제여부
	private int item_price; //단가
	private String name; //지졈명
	private String item_name; //재료명
	
	
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
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
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getRc_amount() {
		return rc_amount;
	}
	public void setRc_amount(int rc_amount) {
		this.rc_amount = rc_amount;
	}
	public Timestamp getRc_time() {
		return rc_time;
	}
	public void setRc_time(Timestamp rc_time) {
		this.rc_time = rc_time;
	}
	public String getRc_note() {
		return rc_note;
	}
	public void setRc_note(String rc_note) {
		this.rc_note = rc_note;
	}
	public String getSh_note() {
		return sh_note;
	}
	public void setSh_note(String sh_note) {
		this.sh_note = sh_note;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
