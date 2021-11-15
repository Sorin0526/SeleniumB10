package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

import java.util.HashSet;
import java.util.Set;

public class NewWindow {
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainTitle = driver.getTitle();
        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        //switch to window  until is equal to about us
        Browsers_Utils.switchByTitle(driver, "About Us");

        Set<String> ids = driver.getWindowHandles();
//
//        for (String id : ids
//        ) {
//            driver.switchTo().window(id);
//            if (driver.getTitle().contains("About Us")) {
//                break;
//            }
//        }
        System.out.println(driver.getTitle());

        //close all the windows except the main window
        Browsers_Utils.closeWindowByTitle(driver, mainTitle);

//        for (String id :ids ) {
//            driver.switchTo().window(id);
//            if ( !driver.getTitle().equals(mainTitle)){
//                driver.close();
//            }
//        }
        }
    }

