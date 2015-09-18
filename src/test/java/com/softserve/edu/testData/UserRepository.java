package com.softserve.edu.testData;

public class UserRepository {
     
	public static IUsers getAdminUser(){
		return User.get()
				.setLogin("admin")
				.setPassword("password")
				.build();
				
	}
	
	
}
