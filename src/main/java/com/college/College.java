package com.college;

import java.util.List;

import com.students.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	@Id
	private int cid;
	private String cname;
	private String cadd;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Student> li;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public List<Student> getLi() {
		return li;
	}

	public void setLi(List<Student> li) {
		this.li = li;
	}

	public College(int cid, String cname, String cadd, List<Student> li) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cadd = cadd;
		this.li = li;
	}
	public College(int cid,String cname,String cadd)
	{
		this.cid = cid;
		this.cname = cname;
		this.cadd = cadd;	
	}
	public College()
	{
		
	}

//	@Override
//	public String toString() {
//		return "College [cid=" + cid + ", cname=" + cname + ", cadd=" + cadd + ", li=" + li + "]";
//	}
	

}
