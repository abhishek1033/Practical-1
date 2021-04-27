package com.practical.reg.repositiry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practical.reg.EntityModel.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> 
{
	@Query("from UserRegistration where STATUS='Y' and USER_NAME=?1 and PASSWORD=?2 ")
	public UserRegistration userLogin(String user_NAME, String password);

	@Query("from UserRegistration where STATUS='Y' and USER_NAME=?1  ")
	public UserRegistration findByUsername(String username);
	

}
