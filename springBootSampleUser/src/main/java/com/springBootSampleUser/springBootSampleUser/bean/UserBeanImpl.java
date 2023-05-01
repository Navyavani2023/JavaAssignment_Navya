package com.springBootSampleUser.springBootSampleUser.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootSampleUser.springBootSampleUser.CustomException.BusinessException;
import com.springBootSampleUser.springBootSampleUser.Dao.UserDao;
import com.springBootSampleUser.springBootSampleUser.entities.CounterClass;
import com.springBootSampleUser.springBootSampleUser.entities.People;


@Service
public class UserBeanImpl implements UserBean {
	@Autowired
	private UserDao userDao;

	@Override
	public List<People> getUsers() {
		List<People> userList = null;
		try {
			userList = userDao.findAll();

		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in the service while fetching all users" + e.getMessage());
		}
		if (userList.isEmpty())
			throw new BusinessException("604", "List is Empty");		
		return userList;
	}

	@Override
	public People addUser(People user) {

		if (user.getName().isEmpty() || user.getName() == null) {
			throw new BusinessException("601", "Name cant be blank");
		}
		
			People userDetailsByName=this.getUserByname(user.getName());
			
			if(userDetailsByName != null)
				throw new BusinessException("624", "duplicate name is not accepted");
			try {
			System.out.println("user^^^^" + user);
			user.setCreatedDatetime(new Date());
			return userDao.save(user);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "give user detail is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something went wrong in the service while saving the Employee" + e.getMessage());
		}
	}

	@Override
	public People getUserById(int id) {
		try {

			return userDao.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "given userid is null" + e.getMessage());
		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("607", "No user data found" + e.getMessage());
		}
	}

	@Override
	public void deleteByUserId(int id) {
		// TODO Auto-generated method stub
		try {
			userDao.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("608", "given userid is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something went wrong in the service while saving the Employee" + e.getMessage());
		}
	}

	@Override
	public List<People> getSecondHighestSalaryUsers() {
		List<People> userList = null;
		try {
			userList = userDao.findSecondHighestPaidUser();
			System.out.println("&&$$####" + userDao.findtheGenderCount());

		} catch (Exception e) {
			throw new BusinessException("615",
					"Something went wrong in the service while fetching second highest paid user" + e.getMessage());
		}
		if (userList.isEmpty())
			throw new BusinessException("616", "List is Empty");
		System.out.println("Impl" + userList);
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public List<CounterClass> getCountOfMaleAndFemale() {
		List<Object[]> counters = null;
		List<CounterClass> resultCounter = new ArrayList<CounterClass>();
		try {
			counters = userDao.findtheGenderCount();

		} catch (Exception e) {
			throw new BusinessException("617",
					"Something went wrong in the service while fetching count of male and female users"
							+ e.getMessage());
		}
		if (counters.isEmpty())
			throw new BusinessException("618", "List is Empty");
		else {

			for (Object[] row : counters) {
				CounterClass sample = new CounterClass(row[0].toString(), Integer.parseInt(row[1].toString()));
				resultCounter.add(sample);
			}
		}
		System.out.println("%%%%%" + resultCounter);
		// TODO Auto-generated method stub
		return resultCounter;
	}

	@Override
	public List<String> getListOfEmails() {
		List<String> userEmails = null;
		try {
			userEmails = userDao.getEmails();
			System.out.println("&&$$####" + userDao.findtheGenderCount());

		} catch (Exception e) {
			throw new BusinessException("619",
					"Something went wrong in the service while fetching the mails" + e.getMessage());
		}
		if (userEmails.isEmpty())
			throw new BusinessException("616", "Mail list is Empty");

		return userEmails;
	}

	@Override
	public People updateTheUser(People people, int id) {

		if (people.getName().isEmpty() || people.getName() == null)
			throw new BusinessException("601", "Name cant be blank");

		People userDetail = this.getUserById(id);		
		try {			
			people.setId(id);
			people.setCreatedDatetime(userDetail.getCreatedDatetime());
			people.setUpdatedDatetime(new Date());
			return userDao.save(people);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "give user detail is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something went wrong in the service while saving the Employee" + e.getMessage());
		}
	}

	@Override
	public People getUserByname(String name) {
	
		People people = userDao.findByName(name);	

		return people;
	}

}
