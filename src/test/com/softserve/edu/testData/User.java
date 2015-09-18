package com.softserve.edu.testData;

import com.softserve.edu.testData.IUsers;

interface ILogin {
	IPassword setLogin(String login);

}

interface IPassword {
	IBuild setPassword(String password);
}

interface IBuild {
	IUsers build();
}

public class User implements ILogin, IBuild, IPassword, IUsers {

	String login;
	String password;

	private User() {

	}

	public static ILogin get() {
		return new User();
	}

	public IPassword setLogin(String login) {
		this.login = login;
		return this;

	}

	public IBuild setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUsers build() {
		return this;
	}

	public String getLogin() {
		
		return login;
	}

	public String getPassword() {
		
		return password;
	}

}
