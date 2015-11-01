package com.softserve.edu.counters.data;

public class UserRepository {
	
	public static IUser getCalibratorUser() {
		return User.get().setFirstname("Людмила")
				.setLastname("")
				.setMiddleName("")
				.setPhoneNumber("")
				.setEmail("")
				.setLogin("calibrator-lv")
				.setPassword("pass")
				.setRegion("")
				.setDistrict("")
				.setCity("")
				.setStreet("")
				.setBuilding("")
				.setFlat("")
				.setRole("")
				.setOrganization("")
				.setWorkInProgress("")
				.build();	
	}
	
	public static IUser getInvalidUser() {
		return User.get().setFirstname("")
				.setLastname("")
				.setMiddleName("")
				.setPhoneNumber("")
				.setEmail("")
				.setLogin("calibrator")
				.setPassword("pass")
				.setRegion("")
				.setDistrict("")
				.setCity("")
				.setStreet("")
				.setBuilding("")
				.setFlat("")
				.setRole("")
				.setOrganization("")
				.setWorkInProgress("")
				.build();
	}
	
	public static IUser getEmployee() {
		return User.get()
				.setFirstname("Роксолана")
				.setLastname("Яоемкевич")
				.setMiddleName("Ігорівна")
				//.setPhoneNumber("+380981323157")
				.setPhoneNumber("+380981323157")
				.setEmail("Yaremkevych.Roksolana@gmail.com")
				.setLogin("roksik")
				.setPassword("pass")
				.setRegion("Львівська")
				.setDistrict("Львів")
				.setCity("Львів")
				.setStreet("Крипа")
				.setBuilding("48")
				.setFlat("0")
				.setRole("CALIBRATOR_EMPLOYEE")
				.setOrganization("ПП «Повірник зі Львова»")
				.setWorkInProgress("0")
				.build();
	}
	
	public static IUser getChangedEmployee() {
		return User.get()
				.setFirstname("Роксолана")
				.setLastname("Сонце")
				.setMiddleName("Ігорівна")
				.setPhoneNumber("+380981323157")
				.setEmail("Yaremkevych.Roksolana@gmail.com")
				.setLogin("roksik")
				.setPassword("pass")
				.setRegion("Львівська")
				.setDistrict("Львів")
				.setCity("Львів")
				.setStreet("Крипа")
				.setBuilding("48")
				.setFlat("0")
				.setRole("CALIBRATOR_EMPLOYEE")
				.setOrganization("ПП «Повірник зі Львова»")
				.setWorkInProgress("0")
				.build();
	}

}
