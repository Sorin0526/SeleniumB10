package javaScriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

public class JS_Practice {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.techtorialacademy.com/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String title =jsExecutor.executeScript("return document.title").toString(); //get title
        System.out.println(title);

        WebElement browseCourse = driver.findElement(By.linkText("Browse Course"));
        jsExecutor.executeScript("arguments [0].click()", browseCourse); // arguments [0] does not change


        WebElement copyRight = driver.findElement(By.xpath("//div/p[contains(text(),'Copyrights')]"));
       //jsExecutor.executeScript("arguments[0].scrollIntoView(false)", copyRight);
        Browsers_Utils.scrollToView(driver,copyRight);
        //find the student login button on the top of the page
        //and scroll the page to top till studentLogin button is visible
        Thread.sleep(500);

        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[contains(text(),'Student login')]\n" +
                "\n"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", studentLogin);







    }
}
