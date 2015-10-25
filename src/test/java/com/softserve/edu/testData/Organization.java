package com.softserve.edu.testData;
import com.softserve.edu.testData.IOrganization;

interface IOrganizationName {
	IOrganizationTypeChoose setOrganizationName(String organizationName);
}
interface IOrganizationTypeChoose{
	IPhoneNumber setOrganizationTypeChoose(String organizationType);
}
interface IPhoneNumber{
	IEmail setPhoneNumber(String phoneNumber);
}
interface IEmail {
	IMaxSizeEpmloyers setEmail(String email);
}

interface IMaxSizeEpmloyers{
	IMaxTimeForFinishRequestInDays setMaxSizeEpmloyers(String maxSizeEpmloyer);
}
interface  IMaxTimeForFinishRequestInDays{
	IAdminFirstName setMaxTimeForFinishRequestInDays(String maxTime);
}
interface IAdminFirstName {
	IAdminLastName setAdminFirstName(String firstname);
}
interface IAdminLastName{
	IAdminSureName setAdminLastName(String lastname);
}
interface IAdminSureName{
	ILoginForSystemAdmin setAdminSureName(String surename);
}
interface ILoginForSystemAdmin{
	IPasswordForSystemAdmin setLoginForSystemAdmin(String login);
}
interface IPasswordForSystemAdmin{
	IConfirmPasswordForSystemAdmin setPasswordForSystemAdmin(String password);
}
interface IConfirmPasswordForSystemAdmin{
	ISelectRegionFromList setConfirmPasswordForSystemAdmin(String password);
}
interface ISelectRegionFromList{
	ISelectDistrictFromList selectRegionFromList(String region);
}

interface ISelectDistrictFromList{
	ISelectCityFromList selectDistrictFromList(String district);
}
interface ISelectCityFromList{
	IStreet selectCityFromList(String city);
}

interface IStreet{
	IHouse setStreetInForm(String street);
}
interface IHouse{
	IFlat setHouseInForm(String house);
}

interface IFlat{
	IBuildOrganization setFlatInForm(String flat);
}

interface IBuildOrganization{
	IOrganization build();
}

public class Organization implements IOrganizationName,IOrganizationTypeChoose,IPhoneNumber,
                                         IEmail,IMaxSizeEpmloyers,IMaxTimeForFinishRequestInDays,
                                         ILoginForSystemAdmin,IPasswordForSystemAdmin,
                                         IConfirmPasswordForSystemAdmin,ISelectRegionFromList,ISelectDistrictFromList,
                                         ISelectCityFromList,IStreet,IHouse,IFlat,IBuildOrganization, IOrganization,IAdminFirstName,IAdminLastName,IAdminSureName {
	
	String organizationName;
	String organizationTypeChoose;
	String phoneNumber;
	String email;
	String maxSizeEpmloyers;
	String maxTimeForFinishRequestInDays;
	String adminFirstName;
	String adminLastName;
	String adminSureName;
	String loginForSystemAdmin;
	String passwordForSystemAdmin;
	String confirmPasswordForSystemAdmin;
	String selectRegionFromList;
	String selectDistrictFromList;
	String selectCityFromList;
	String street;
	String house;
    String flat;
    
    private Organization(){
    	
    }
    public static IOrganizationName get(){
    	return new Organization();
    }
    
    public IOrganizationTypeChoose setOrganizationName(String organizationName){
    	this.organizationName = organizationName;
    	return this;
    }
    
    public IPhoneNumber setOrganizationTypeChoose(String organizationType){
    	this.organizationTypeChoose = organizationType;
    	return this;
    }
    
    public IEmail setPhoneNumber(String phoneNumber){
    	this.phoneNumber = phoneNumber;
    	return this;
    }
    
    public IMaxSizeEpmloyers setEmail(String email){
    	return this;
    }
    
    public IMaxTimeForFinishRequestInDays setMaxSizeEpmloyers(String maxSizeEpmloyer){
    	this.maxSizeEpmloyers = maxSizeEpmloyer;
    	return this;
    }
    public IAdminFirstName setMaxTimeForFinishRequestInDays(String maxTime){
    	this.maxTimeForFinishRequestInDays = maxTime;
    	return this;
    }
    
    public IAdminLastName setAdminFirstName(String firstname){
    	this.adminFirstName = firstname;
    	return this;
    }
    public IAdminSureName setAdminLastName(String lastname){
    	this.adminLastName = lastname;
    	return this;
    }
    
    public ILoginForSystemAdmin setAdminSureName(String surename){
    	this.adminSureName = surename;
    	return this;
    }
    public IPasswordForSystemAdmin setLoginForSystemAdmin(String login){
    	this.loginForSystemAdmin = login;
    	return this;
    }
    public IConfirmPasswordForSystemAdmin setPasswordForSystemAdmin(String password){
    	this.passwordForSystemAdmin = password;
    	return this;
    }
    
    public ISelectRegionFromList setConfirmPasswordForSystemAdmin(String password){
    	this.confirmPasswordForSystemAdmin = password;
    	return this;
    }
    
    public ISelectDistrictFromList selectRegionFromList(String region){
    	this.selectRegionFromList = region;
    	return this;
    }
    public ISelectCityFromList selectDistrictFromList(String district){
    	this.selectDistrictFromList = district;
    	return this;
    }
    
    public IStreet selectCityFromList(String city){
    	this.selectCityFromList = city;
    	return this;
    }
    
    public IHouse setStreetInForm(String street){
    	this.street = street;
    	return this;
    }
    public IFlat setHouseInForm(String house){
    	this.house = house;
    	return this;
    }
    public IBuildOrganization setFlatInForm(String flat){
    	this.flat = flat;
    	return this;
    }
    public IOrganization build(){
    	return this;
    }
	
	public String getOrganizationName() {
		return organizationName;
	}
	
	public String getOrganizationTypeChoose() {
		return organizationTypeChoose;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public String getMaxSizeEpmloyers() {
		
		return maxSizeEpmloyers;
	}
	
	public String getMaxTimeForFinishRequestInDays() {
		
		return maxTimeForFinishRequestInDays;
	}
	
	public String getAdminFirstName(){
		return adminFirstName;
	}
	public String getAdminLastName(){
		return adminLastName;
	}
	public String getAdminSureName(){
		return adminSureName;
	}
	public String getLoginForSystemAdmin() {
		
		return loginForSystemAdmin;
	}
	
	public String getPasswordForSystemAdmin() {
		
		return passwordForSystemAdmin;
	}
	
	public String getConfirmPasswordForSystemAdmin() {
		
		return confirmPasswordForSystemAdmin;
	}
	
	public String getSearchRegionList() {
		
		return selectRegionFromList;
	}
	
	public String getSearchDistrictlist() {
		
		return selectDistrictFromList;
	}
	public String getSearchCityList(){
		return selectCityFromList;
	}
	
	public String getStreet() {
		
		return street;
	}
	
	public String getHouse() {
		
		return house;
	}
	
	public String getFlat() {
	
		return flat;
	}
    
}
