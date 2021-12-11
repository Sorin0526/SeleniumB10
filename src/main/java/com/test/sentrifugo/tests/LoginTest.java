package com.test.sentrifugo.tests;

import com.test.sentrifugo.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validationSuperAdmin(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");


    }
    @Test
    public void validateManagement(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("EM02", "sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");

    }
    @Test
    public void validateManager(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("EMO3", "sentrifugo");
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");

    }

    @Test
    public void validateLoginTextMessage(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.noParametersLogin();
        Assert.assertTrue(loginPage.loginErrTxtDisplayed());
        Assert.assertTrue(loginPage.loginErrGetText("Please enter username or email.","Please enter password."));
        Assert.assertTrue(loginPage.loginErrTxtColor("#ff0000"));

    }
}
