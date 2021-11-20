package alert_Popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Browsers_Utils;


public class SweetAlert {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        System.out.println("It will run before each test annotation");
    }

    @Test
    public  void  sweetAlert() throws InterruptedException {


//        driver.get("https://sweetalert.js.org/");
        SoftAssert softAssert= new SoftAssert();
        WebElement swal = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        swal.click();
        WebElement popupMessage=driver.findElement(By.xpath("//div[@class=\"swal-text\"]"));
        String actualMessge = Browsers_Utils.getText(popupMessage).trim();
        softAssert.assertEquals(actualMessge, "Something went wrong!");
        WebElement okButton = driver.findElement(By.xpath("//button[@class=\"swal-button swal-button--confirm\"]"));
        okButton.click();
        Thread.sleep(1000);
        Assert.assertFalse(okButton.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void jsAlert() throws InterruptedException {
//        WebDriver driver= new ChromeDriver();
//        driver.get("https://sweetalert.js.org/");
        WebElement alert = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        alert.click();
        Thread.sleep(1000);
        Alert alert1=driver.switchTo().alert();
        alert1.accept();

    }


    @AfterMethod
    public void tearDown(){
        System.out.println("It will run after each test annotation");
        driver.quit();
    }

}
