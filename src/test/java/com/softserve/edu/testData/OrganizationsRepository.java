package com.softserve.edu.testData;

public class OrganizationsRepository {
      public static IOrganization getNewOrganizationData(){
    	  return Organization.get()
    			  .setOrganizationName("ЛьвівГаз")
    			  .setOrganizationTypeChoose("Постачальник")
    			  .setPhoneNumber("975285562")
    			  .setEmail("example@gmail.com")
    			  .setMaxSizeEpmloyers("50")
    			  .setMaxTimeForFinishRequestInDays("10")
    			  .setAdminFirstName("Петро")
    			  .setAdminLastName("Петренко")
    			  .setAdminSureName("Петрович")
    			  .setLoginForSystemAdmin("admin1")
    			  .setPasswordForSystemAdmin("pass")
    			  .setConfirmPasswordForSystemAdmin("pass")
    			  .selectRegionFromList("Львівська")
    			  .selectDistrictFromList("Львів")
    			  .selectCityFromList("Львів")
    			  .setStreetInForm("Наукова")
    			  .setHouseInForm("150")
    			  .setFlatInForm("152")
    			  .setDeviceType("Хол")
    			  .build();
      }
}
