package com.students;

import com.college.College;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentsRecords")
public class Student {

	@Id
	private int sid;
	private String sname;
	private int smarks;
	
	@ManyToOne(fetch = FetchType.LAZY	)
	private College college;
	
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	public Student(int sid, String sname, int smarks,College college) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smarks = smarks;
		this.college=college;
	}
	
	public Student()
	{
		
	}
	
	@Override
	public String toString() {
	    return "Student [sid=" + sid +
	           ", sname=" + sname +
	           ", smarks=" + smarks +
	           ", College ID=" + (college != null ? college.getCid() : null) +
	           "]";
	}
	
	
}
