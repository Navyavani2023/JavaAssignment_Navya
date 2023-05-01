package com.springBootSampleUser.springBootSampleUser.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int empid;
	private String empname;
	private double salary;
	private int deptno;
	private int mgr;
	private double comm;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Employee(int empid, String empname, double salary, int deptno, int mgr, double comm) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.deptno = deptno;
		this.mgr = mgr;
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", deptno=" + deptno
				+ ", mgr=" + mgr + ", comm=" + comm + "]";
	}
	public Employee() {
		super();
	}
	
}
