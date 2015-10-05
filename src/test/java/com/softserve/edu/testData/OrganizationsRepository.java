package com.softserve.edu.testData;

public class OrganizationsRepository {
      public static IOrganization getNewOrganizationData(){
    	  return Organization.get()
    			  .setOrganizationName("ЛьвівГаз")
    			  .setOrganizationTypeChoose("Постачальник")
    			  .setPhoneNumber("0975285562")
    			  .setEmail("blabla@foo.com")
    			  .setMaxSizeEpmloyers("50")
    			  .setMaxTimeForFinishRequestInDays("10")
    			  .setLoginForSystemAdmin("admin1")
    			  .setPasswordForSystemAdmin("pass")
    			  .setConfirmPasswordForSystemAdmin("pass")
    			  .selectRegionFromList("Львівська")
    			  .selectDistrictFromList("Жовк")
    			  .selectCityFromList("Нагірці")
    			  .setStreetInForm("Франка")
    			  .setHouseInForm("150")
    			  .setFlatInForm("152")
    			  .build();
      }
}
