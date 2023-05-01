 package com.springBootSampleUser.springBootSampleUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springBootSampleUser.springBootSampleUser.CustomException.BusinessException;
import com.springBootSampleUser.springBootSampleUser.CustomException.ControllerException;
import com.springBootSampleUser.springBootSampleUser.bean.UserBean;
import com.springBootSampleUser.springBootSampleUser.entities.CounterClass;
import com.springBootSampleUser.springBootSampleUser.entities.People;

//TODO: Add ControlAdvice
@RestController
public class MyController {
	
	@Autowired
	private UserBean userBean;
	
	@GetMapping("/Users")
	public ResponseEntity<?> getUsers()
	
	{
		try {
		List<People> allUsers=this.userBean.getUsers();
		return new ResponseEntity<List<People>>(allUsers,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody People people) {
		try {
		People resultPeople=this.userBean.addUser(people);
		
		return new ResponseEntity<People>(resultPeople, HttpStatus.CREATED);
		}catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/User/{userid}")
	public ResponseEntity<?> getUserById(@PathVariable("userid") int id)
	{
		try {
		People userData=this.userBean.getUserById(id);
		return new ResponseEntity<People>(userData,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<?> deleteById(@PathVariable("userid") int id)
	{
		try {
		this.userBean.deleteByUserId(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping("/updateUser/{userid}")
	public ResponseEntity<?> updateUser(@RequestBody People people,@PathVariable("userid") int id) {
		try {			
		People resultPeople=this.userBean.updateTheUser(people,id);
		
		return new ResponseEntity<People>(resultPeople, HttpStatus.CREATED);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/SecondHighestSalaryPaidUsers")
	public ResponseEntity<?> getSecondHighestSalaryUsers()
	
	{
		try {
		List<People> allUsers=this.userBean.getSecondHighestSalaryUsers();
		return new ResponseEntity<List<People>>(allUsers,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/countOfMaleAndFemale")
	public ResponseEntity<?> getCountOfMaleAndFemale()
	
	{
		try {
		List<CounterClass> counter=this.userBean.getCountOfMaleAndFemale();
		return new ResponseEntity<List<CounterClass>>(counter,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/getListOfEmails")
	public ResponseEntity<?> getListOfEmails()
	
	{
		try {
		List<String> emailsList=this.userBean.getListOfEmails();
		return new ResponseEntity<List<String>>(emailsList,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("609","something went wrong in controller"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
}
