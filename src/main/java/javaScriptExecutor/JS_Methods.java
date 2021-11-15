package javaScriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JS_Methods {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement copyRights= driver.findElement(By.xpath("//div/p[contains(text(),'Copyrights')]"));
        Point location = copyRights.getLocation();
        System.out.println(location.getY());
        System.out.println(location.getX());

        int xCoord = location.getX();
        int yCoord= location.getY();

        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollTo("+xCoord+","+yCoord+")");

        Thread.sleep(2000);
        jsExecutor.executeScript("history.go(0)");// refresh the page



    }
}
