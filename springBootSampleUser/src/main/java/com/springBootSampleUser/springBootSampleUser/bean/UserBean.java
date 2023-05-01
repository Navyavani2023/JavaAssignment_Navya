package com.springBootSampleUser.springBootSampleUser.bean;

import java.util.List;

import com.springBootSampleUser.springBootSampleUser.entities.CounterClass;
import com.springBootSampleUser.springBootSampleUser.entities.People;


//import com.springBootSampleUser.springBootSampleUser.entities.User;

public interface UserBean {
	public List<People> getUsers();

	public People addUser(People people);

	public People getUserById(int id);

	public void deleteByUserId(int id);

	public List<People> getSecondHighestSalaryUsers();

	public List<CounterClass> getCountOfMaleAndFemale();

	public List<String> getListOfEmails();

	public People updateTheUser(People people, int id);

	public People getUserByname(String name);
	
}
