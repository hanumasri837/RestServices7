package com.projectcodeforce.one.config;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface UserRepository
{

	User findById(String i);

	public void save(User theUser);

	

	
}
