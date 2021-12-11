package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // initializing with the help of constructor
    // it will initialize elements stored in this class

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    @FindBy(id="username")
    WebElement userName;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy(id="usernameerror")
    WebElement usernameErrTxt;

    @FindBy(id="pwderror")
    WebElement passErrTxt;



    //driver.findElement (By.id("")); --> no more using this syntax


    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public void noParametersLogin(){
        this.loginButton.click();
    }

    public boolean loginErrTxtDisplayed(){
        this.usernameErrTxt.isDisplayed();
        this.passErrTxt.isDisplayed();
        return true;
    }

    public boolean loginErrGetText(String userExpectedErrTxt, String passExpectedErrTxt) {
        this.usernameErrTxt.getText();
        this.password.getText();
        if (userExpectedErrTxt.equals(userExpectedErrTxt) && passErrTxt.equals(passExpectedErrTxt)) {
        }
        return true;
    }

    public boolean loginErrTxtColor(String colorcode){
        String colorUser = this.usernameErrTxt.getCssValue("color");
        String passColor =this.passErrTxt.getCssValue("color");
        if(colorUser.equals(colorcode)&& passColor.equals(colorcode)){
        }
        return true;
    }



    /*
    TEST case 1
1- go to the sentrifugo page
2- click login button
3- validate please enter user and password message are displayed.
4- validate text of those message
5- validate color of the texts are red
Test Case 2
1- go to the page
2- enter invalid username and validate the message
Test Case 3
1- go to the page
2- enter invalid password and validate the message
Test Case 4
1- go to the page
2- enter invalid username and password and validate the message
     */



}
