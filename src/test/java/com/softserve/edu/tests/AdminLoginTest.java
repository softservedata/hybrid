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
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ContextUtils;
import com.softserve.edu.atqc.tools.search.ExplicitWrapper;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;

import com.softserve.edu.pages.AdminHomePage;
import com.softserve.edu.pages.AdminHomePage.ValidationHeader;
import com.softserve.edu.pages.LoginPage;
import com.softserve.edu.pages.OrganizationPage;
import com.softserve.edu.pages.StartMainPage;
import com.softserve.edu.pages.MainPage;
import com.softserve.edu.testData.IOrganization;
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
public void AdministratorLogin(ABrowser browser, String url, IUsers adminUser) throws Exception{
	LoggerUtils.get().infoLog("Thread ID= " + Thread.currentThread().getId()
            + "  User is " + adminUser.getLogin());
	
	LoginPage loginPage =StartMainPage.load(browser, url).gotoLoginPage();
	
	AdminHomePage adminHomePage = loginPage.successAdminLogin(UserRepository.getAdminUser());
	//Thread.sleep(3000);
	//ExplicitWrapper.get().getPresentWebElement(ByWrapper.getByXPath(".//*[@id='adminModule']/nav/ul/li/a/div/label"));
	AssertWrapper.get().forElement(adminHomePage.getPageHeaderText()).valueMatch(ValidationHeader.HEADER.toString());
	
	AssertWrapper.get().check();
	adminHomePage.logOut();//
	
}

@DataProvider//(parallel = true)
public Object[][] organizationCreate() {
    return new Object[][] {
        { BrowserRepository.getDefault(),
            Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser(), OrganizationsRepository.getNewOrganizationData()},
        
       
    };
}

@Test(dataProvider = "organizationCreate")
public void organizationCreation(ABrowser browser, String url, IUsers adminUser, IOrganization newOrg) throws Exception{
	
	
	//LoginPage loginPage = (new MainPage()).gotoLoginPage();
	AdminHomePage adminHomePage = (new MainPage()).gotoLoginPage().successAdminLogin(adminUser);
	
	OrganizationPage orgPage = adminHomePage.gotoOrganizationPage();
	OrganizationPage.AddNewOrganizationForm newForm = orgPage.addNewOrganizationClick();
	newForm.successAddOrganization(newOrg);
    
    }

}

