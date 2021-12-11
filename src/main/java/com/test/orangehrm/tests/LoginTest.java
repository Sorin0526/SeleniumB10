package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.data.LoginCred;
import com.test.orangehrm.pages.LoginPage;
import com.test.sentrifugo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    /*
    valid username, invalid password
    invalid username , invalid password
    invalid username, valid password
    valid username , valid password(admin. super admin. employee, hr)
     */
    @Test(dataProvider ="credentials", dataProviderClass = LoginCred.class)
    public void validateNegativeCredLogin(String username, String password, String expected){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getErrorMessage(),expected);
    }



}
