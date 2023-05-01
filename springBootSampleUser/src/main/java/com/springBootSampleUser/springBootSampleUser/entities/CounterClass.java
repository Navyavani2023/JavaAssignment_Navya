package com.springBootSampleUser.springBootSampleUser.entities;

public class CounterClass {
	private String gender;
	private int count;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CounterClass [gender=" + gender + ", count=" + count + "]";
	}
	public CounterClass(String gender, int count) {
		super();
		this.gender = gender;
		this.count = count;
	}

}
