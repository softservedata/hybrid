package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.loggers.LoggerRepository;
import com.softserve.edu.atqc.tools.loggers.LoggerUtils;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;

import com.softserve.edu.pages.AdminHomePage;
import com.softserve.edu.pages.LoginPage;
import com.softserve.edu.pages.OrganizationPage;
import com.softserve.edu.pages.MainPage;
import com.softserve.edu.testData.IUsers;
import com.softserve.edu.testData.OrganizationsRepository;
import com.softserve.edu.testData.UrlRepository;
import com.softserve.edu.testData.UrlRepository.Urls;
import com.softserve.edu.testData.UserRepository;

public class AdminLoginTest {

	@DataProvider//(parallel = true)
    public Object[][] adminUser() {
        return new Object[][] {
            { BrowserRepository.getDefault(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser() },
           
        };
    }

@Test(dataProvider = "adminUser")
public void AdministratorLogin(ABrowser browser, String url, IUsers adminUser){
	
	
	LoginPage loginPage = (new MainPage()).gotoLoginPage();
	AdminHomePage adminHomePage = loginPage.successAdminLogin(UserRepository.getAdminUser());
	
	Assert.assertEquals(true, adminHomePage.getPageHeader().isDisplayed());
	adminHomePage.logOut();
	
}

@Test
public void organizationCreation() throws InterruptedException{
	
	
	LoginPage loginPage = (new MainPage()).gotoLoginPage();
	AdminHomePage adminHomePage = loginPage.successAdminLogin(UserRepository.getAdminUser());
	
	OrganizationPage orgPage = adminHomePage.gotoOrganizationPage();
	OrganizationPage.AddNewOrganizationForm newForm = orgPage.addNewOrganizationClick();
	newForm.successAddOrganization(OrganizationsRepository.getNewOrganizationData());
    
    }

}

