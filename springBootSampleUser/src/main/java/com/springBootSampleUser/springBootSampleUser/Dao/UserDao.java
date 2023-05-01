package com.springBootSampleUser.springBootSampleUser.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springBootSampleUser.springBootSampleUser.entities.People;


public interface UserDao extends JpaRepository<People, Integer>{
	@Query(value="select * from people where salary=(select max(salary) from people where salary <(select max(salary) from people))",nativeQuery= true)
public List<People> findSecondHighestPaidUser();
	
	@Query(value="select gender,count(*) from people GROUP BY gender",nativeQuery= true)
	public List<Object[]> findtheGenderCount();
	
	@Query(value="select email from people",nativeQuery = true)
	public List<String> getEmails();

	public People findByName(String name);
	
	
}
