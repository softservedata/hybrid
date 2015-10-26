package com.softserve.edu.oms.tests;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.mockito.Mockito;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.data.ConnectionUtils;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;
import com.softserve.edu.oms.dao.UserDao;
import com.softserve.edu.oms.data.DataSourceRepository;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageConditions;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageFields;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.pages.StartLoginPage;
import com.softserve.edu.oms.service.UserService;

public final class MockTest {


    @DataProvider//(parallel = true)
    public Object[][] newUsers() {
        return new Object[][] {
            { BrowserRepository.getDefault(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getNewUser() },
        };
    }

    @Test(dataProvider = "newUsers")
    public void checkNewUserCreate(ABrowser browser, String url, IUser newUser)
            throws NoSuchFieldException, SecurityException,
                IllegalArgumentException, IllegalAccessException {
        // PreCondition
        CreateNewUserPage createNewUserPage = StartLoginPage.load(browser, url)
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage()
                .gotoCreateNewUserPage();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(newUser);
        administrationPage.searchByLoginName(AdministrationPageFields.LOGIN_NAME,
                AdministrationPageConditions.EQUALS, newUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(newUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successLogin(newUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(homePage.getFirstname())
                    .valueMatch(newUser.getFirstname())
                    .valueStartsWith(newUser.getFirstname().substring(0,1))
                    .next()
                .forElement(homePage.getLastname())
                    .valueMatch(newUser.getLastname())
                    .next()
                .forElement(homePage.getRole().getText())
                    .valueMatch(newUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage();
        // Return to Previous State
        administrationPage.deleteByLoginName(newUser);
        //
        // Origin
//        UserService.get(DataSourceRepository.getJtdsMsSqlLocal())
//            .deleteUsersByPartialLogin(newUser.getLogin());
        //
        // Mock UserService
        //UserService userServiceMock = Mockito.mock(UserService.class);
        //userServiceMock.deleteUsersByPartialLogin(newUser.getLogin());
        //
        // Use UserDao Mock
        UserService userService = UserService.get(DataSourceRepository.getJtdsMsSqlLocal());
        UserDao userDaoMock = Mockito.mock(UserDao.class);
        Mockito.stub(userDaoMock.deleteUsersByPartialLogin(newUser.getLogin()))
            .toReturn(true);
        // Reflection API
        Field userDaoField = userService.getClass().getDeclaredField("userDao");
        userDaoField.setAccessible(true);
        userDaoField.set(userService, userDaoMock);
        //
        boolean resultDelete = userService.deleteUsersByPartialLogin(newUser.getLogin());
        //
        // Save Actual Result. Preparation for Checking
//        AssertWrapper.get()
//                .forElement(administrationPage.getAlert())
//                .valueMatchInLastMessage(
//                        MessageRepository.AdministrationPageNotes.ALERT_DELETE_MESSAGE
//                                .toString());
        administrationPage.logout();
        // Checking
        AssertWrapper.get().check();
        //Mockito.verify(userServiceMock).deleteUsersByPartialLogin(newUser.getLogin());
        Mockito.verify(userDaoMock).deleteUsersByPartialLogin(newUser.getLogin());
        Assert.assertTrue(resultDelete);
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.quitAll();
        ConnectionUtils.closeConnection();
    }

}
