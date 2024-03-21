package com.itwillbs.domain;

import java.sql.Timestamp;

public class OrderDTO {
	
	private int od_num; //거래 번호
	private int num; //지점 번호
	private int item_num; //재료 번호
	private int od_amount; //발주량/수주량
	private Timestamp od_time; //발주일시
	private int received_not; //입고여부
	private String od_note; //발주적요
	private String ob_note; //수주적요
	
	
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
	public int getOd_amount() {
		return od_amount;
	}
	public void setOd_amount(int od_amount) {
		this.od_amount = od_amount;
	}
	public Timestamp getOd_time() {
		return od_time;
	}
	public void setOd_time(Timestamp od_time) {
		this.od_time = od_time;
	}
	public int getReceived_not() {
		return received_not;
	}
	public void setReceived_not(int received_not) {
		this.received_not = received_not;
	}
	public String getOd_note() {
		return od_note;
	}
	public void setOd_note(String od_note) {
		this.od_note = od_note;
	}
	public String getOb_note() {
		return ob_note;
	}
	public void setOb_note(String ob_note) {
		this.ob_note = ob_note;
	}
}
