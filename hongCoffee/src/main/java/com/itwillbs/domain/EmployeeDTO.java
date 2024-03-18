package com.itwillbs.domain;

import java.sql.Timestamp;

public class EmployeeDTO {
	
	private int emp_num; //번호
	private String emp_pw; //비밀번호
	private String emp_name; //이름
	private String emp_phone; //연락처
	private String emp_email; //이메일
	private Timestamp emp_birth; //생년월일
	private int emp_state; //상태(재직=0,휴직=1,퇴직=2)
	private String emp_dept; //부서(인사부, 영업부, 재무부)
	private String emp_rank; //직급(대표, 팀장, 대리, 사원)
	private int emp_right; //권한(일반=0, 관리자=1)
	private Timestamp hire_date; //입사일
	private Timestamp quit_date; //퇴사일
	
	public int getEmp_num() {
		return emp_num;
	}
	public void setEmp_num(int emp_num) {
		this.emp_num = emp_num;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public Timestamp getEmp_birth() {
		return emp_birth;
	}
	public void setEmp_birth(Timestamp emp_birth) {
		this.emp_birth = emp_birth;
	}
	public int getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(int emp_state) {
		this.emp_state = emp_state;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public String getEmp_rank() {
		return emp_rank;
	}
	public void setEmp_rank(String emp_rank) {
		this.emp_rank = emp_rank;
	}
	public int getEmp_right() {
		return emp_right;
	}
	public void setEmp_right(int emp_right) {
		this.emp_right = emp_right;
	}
	public Timestamp getHire_date() {
		return hire_date;
	}
	public void setHire_date(Timestamp hire_date) {
		this.hire_date = hire_date;
	}
	public Timestamp getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(Timestamp quit_date) {
		this.quit_date = quit_date;
	}
	
}
