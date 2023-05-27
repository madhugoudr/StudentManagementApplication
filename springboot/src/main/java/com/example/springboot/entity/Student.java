package com.example.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "student")
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int sid;
	@Column(name= "Sname")
	private String sName;
	@Column(name= "Sgrade")
	private String sGrade;
	@Column(name= "Saddress")
	private String sAddress;
	
	
	public int getsid() {
		return sid;
	}
	public void setsid(int sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsGrade() {
		return sGrade;
	}
	public void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sName, String sGrade, String sAddress) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sGrade = sGrade;
		this.sAddress = sAddress;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sGrade=" + sGrade + ", sAddress=" + sAddress + "]";
	}
	

}
