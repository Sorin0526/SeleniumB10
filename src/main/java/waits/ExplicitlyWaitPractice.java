package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class ExplicitlyWaitPractice {

    // implicitly wait - it will for given duration for the WebElement that our driver is pointing
    //driver.manage.timeOut().implicitlyWait (5, Duration.ofSeconds(5));

    //Explicitly wait:
    //it will wait for one element while the condition is achieved
        //element to be- clickable, visible, unvisible, isalertpresent, is frameavailableandswitchtoframe()
        //WebDriverWait wait = new WebdriverWait(driver, DurationOfSeconds(5));
        //WebElement element = wait.until(expectedconditons.elementToBeClickable(driver, findElement(by.id("idvalue"))))


    //FluentWait: we have one smaller time unit that check the element each time until max time reached. if we cannot find the element till max time , it will throw the exception.

    @Test
    public void validateWait(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//button"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement hello = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));

        Assert.assertEquals(hello.getText(),"Hello World!");
    }

}
