package com.test.esty.tests;

import com.test.esty.TestBase;
import com.test.esty.pages.EtsyHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTest extends TestBase {

    @Parameters("items")
    @Test

    public void etsySearchTest(String item){
        EtsyHomePage homePage = new EtsyHomePage(driver);
        homePage.searchItem(item);
        Assert.assertTrue((homePage.validateTitle()));


    }
//homework:
    //change validateTitle method implementation that will work with all the search values.
    //now is working only with "java programming mug"

    @Test
    public void  test(){
        EtsyHomePage homePage = new EtsyHomePage(driver);
        homePage.searchItem("winter gloves");
        Assert.assertTrue(homePage.validateTitle());
    }


}
