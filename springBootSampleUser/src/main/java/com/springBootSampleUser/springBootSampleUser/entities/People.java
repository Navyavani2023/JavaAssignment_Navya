package com.springBootSampleUser.springBootSampleUser.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "people")
//TODO: Use lombok
//TODO: Use javax validation in DTO class
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String name;
	private String email;
	private String gender;
	private long salary;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date createdDatetime;
	private Date updatedDatetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}
	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", salary=" + salary
				+ ", createdDatetime=" + createdDatetime + ", updatedDatetime=" + updatedDatetime + "]";
	}
	public People(int id, String name, String email, String gender, long salary, Date createdDatetime,
			Date updatedDatetime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.salary = salary;
		this.createdDatetime = createdDatetime;
		this.updatedDatetime = updatedDatetime;
	}
	public People() {
		super();
	}
	
	
}
