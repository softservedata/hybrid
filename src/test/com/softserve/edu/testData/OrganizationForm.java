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
	IMaxTimeForFinishRequestInDays setMaxSizeEpmloyer(String maxSizeEpmloyer);
}
interface  IMaxTimeForFinishRequestInDays{
	ILoginForSystemAdmin setMaxTimeForFinishRequestInDays(String maxTime);
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

public class OrganizationForm {

}
