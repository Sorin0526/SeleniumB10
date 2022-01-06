package testNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        System.out.println(" you can use to setup your chrome browser properties, delete cookies ");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        System.out.println("launch the browser");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
        System.out.println("navigate to the website");

         }

    @BeforeMethod
    public void beforeMethode(){
        System.out.println("Before Method");
    }

    @Test
    public void test1(){
        System.out.println("Test -1");
    }

    @Test
    public void test2(){
        System.out.println("Test -2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        System.out.println("take screenshot for failed test annotations");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
