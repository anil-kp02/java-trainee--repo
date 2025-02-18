package com.assn_9.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class StudentHiber {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String f_name;
	private String m_name;
	private String l_name;
	private String branch;
	private String sex;
	private String addrs;
	private String hobby;
	
	
	
	public StudentHiber() {
		super();
	}

	


	@Override
	public String toString() {
		return "StudentHiber [id=" + id + ",\n f_name=" + f_name + ",\n m_name=" + m_name + ",\n l_name=" + l_name
				+ ",\n branch=" + branch + ",\n sex=" + sex + ",\n addrs=" + addrs + ",\n hobby=" + hobby + "]";
	}




	public StudentHiber(String f_name, String m_name, String l_name, String branch, String sex, String addrs,
			String hobby) {
		super();
		this.f_name = f_name;
		this.m_name = m_name;
		this.l_name = l_name;
		this.branch = branch;
		this.sex = sex;
		this.addrs = addrs;
		this.hobby = hobby;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getF_name() {
		return f_name;
	}



	public void setF_name(String f_name) {
		this.f_name = f_name;
	}



	public String getM_name() {
		return m_name;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public String getL_name() {
		return l_name;
	}



	public void setL_name(String l_name) {
		this.l_name = l_name;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getAddrs() {
		return addrs;
	}



	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	

}
