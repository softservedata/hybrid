package com.softserve.edu.counters.data;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	IMiddleName setLastname(String lastname);
}

interface IMiddleName {
	IPhoneNumber setMiddleName(String middleName);
}

interface IPhoneNumber {
	IEmail setPhoneNumber(String phoneNumber);
}

interface IEmail {
	ILogin setEmail(String email);
}

interface ILogin {
	IPassword setLogin(String login);
}

interface IPassword {
	IRegion setPassword(String password);
}

interface IRegion {
	IDistrict setRegion(String region);
}

interface IDistrict {
	ISity setDistrict(String district);
}

interface ISity {
	IStreet setSity(String sity);
}

interface IStreet {
	IBuilding setStreet(String street);
}

interface IBuilding {
	IFlat setBuilding(String building);
}

interface IFlat {
	IRole setFlat(String flat);
}

interface IRole {
	IOrganization setRole(String role);
}

interface IOrganization {
	IWorkInProgress setOrganization(String organization);
}

interface IWorkInProgress {
	IBuild setWorkInProgress(String workInProgress);
}

interface IBuild {
	IUser build();
}


public class User implements IUser, IFirstname, ILastname, IMiddleName, IPhoneNumber, IEmail, ILogin, IPassword, IRegion,
		IDistrict, ISity, IStreet, IBuilding, IFlat, IRole, IOrganization, IWorkInProgress, IBuild {

	String firstname;
	String lastname;
	String middleName;
	String phoneNumber;
	String email;
	
	String login;
	String password;
	
	String region;
	String district;
	String sity;
	String street;
	String building;
	String flat;
	
	String role;
	String organization;
	String workInProgress;
	
	private User() {}
	
	public static IFirstname get() {
        return new User();
    }
	
	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public IMiddleName setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public IPhoneNumber setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public IEmail setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public ILogin setEmail(String email) {
		this.email = email;
		return this;
	}

	public IPassword setLogin(String login) {
		this.login = login;
		return this;
	}

	public IRegion setPassword(String password) {
		this.password = password;
		return this;
	}

	public IDistrict setRegion(String region) {
		this.region = region;
		return this;
	}

	public ISity setDistrict(String district) {
		this.district = district;
		return this;
	}

	public IStreet setSity(String sity) {
		this.sity = sity;
		return this;
	}

	public IBuilding setStreet(String street) {
		this.street = street;
		return this;
	}

	public IFlat setBuilding(String building) {
		this.building = building;
		return this;
	}

	public IRole setFlat(String flat) {
		this.flat = flat;
		return this;
	}

	public IOrganization setRole(String role) {
		this.role = role;
		return this;
	}
	
	public IWorkInProgress setOrganization(String organization) {
		this.organization = organization;
		return this;
	}
	
	public IBuild setWorkInProgress(String workInProgress) {
		this.workInProgress = workInProgress;
		return this;
	}
	
	public IUser build() {
        return this;
    }
	
	//----------------------------------------------
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRegion() {
		return region;
	}

	public String getDistrict() {
		return district;
	}

	public String getSity() {
		return sity;
	}

	public String getStreet() {
		return street;
	}

	public String getBuilding() {
		return building;
	}

	public String getFlat() {
		return flat;
	}

	public String getRole() {
		return role;
	}

	public String getOrganization() {
		return organization;
	}
	public String getWorkInProgress() {
		return workInProgress;
	}




}
