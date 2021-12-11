package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

import java.lang.reflect.Field;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title=\"Add\"]")
    WebElement addButton;

    @FindBy(id="deptcode")
    WebElement departmentCode;

    @FindBy(id="deptname")
    WebElement deppartmentName;

    @FindBy(id="submitbutton")
    WebElement submitButton;

    @FindBy(className="ml-alert-1-success")
    WebElement successMessage;

    public void clickAddButton(){
        addButton.click();
    }

    public  void sendDepartmentInfo(String deptName, String deptCode){

        deppartmentName.sendKeys(deptName);
        departmentCode.sendKeys(deptCode);
    }

    public void clickSubmit(){
        submitButton.submit();
    }

    public String getSuccessMessage(){
        return Browsers_Utils.getText(successMessage);
    }
}
