package com.projectcodeforce.one.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp {

	//@Autowired
	private UserRepository userrepo;
		
	
	//@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(String i) {
		// TODO Auto-generated method stub
		User u = null;
		Optional<User> ou = Optional.ofNullable(userrepo.findById(i));
		if(ou.isPresent()) {
			u = ou.get();
	}
			
	return u;
	}

	//@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub
		userrepo.save(theUser);
	}

//	//@Override
//	public void deleteById(int theId) {
//		// TODO Auto-generated method stub
//		userrepo.deleteById(theId);
//	}

}
