package actionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

import java.security.PublicKey;

public class DragAndDropPractice {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        //how to zoom out or zoom in a web page
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("document.body.style.zoom = '0.5'");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement orangeBox = driver.findElement(By.className("test2"));
        String actualText = Browsers_Utils.getText(orangeBox);
        String expectedText="... Or here.";

        Assert.assertEquals(actualText,expectedText);

//        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler\n" +
//                "\n"));
//        cookies.click();
//
//        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,orangeBox).perform();


        // we should reinitialize the orangeBox to overcome the stakeElementReferenceExemption
        orangeBox = driver.findElement(By.className("test2"));
        String succesMessage = Browsers_Utils.getText(orangeBox);
        String expectedMessage ="You did great!";

        Assert.assertEquals(succesMessage,expectedMessage);

        String cssValue = orangeBox.getCssValue("background-color");
        System.out.println(cssValue);

        Assert.assertEquals(cssValue, "rgba(238, 111, 11, 1)");

    }
    @Test
    public void test2 (){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");


        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement blueBox = driver.findElement(By.className("test1"));

        Actions actions = new Actions(driver);
        actions.click(draggable).moveToElement(blueBox).release().perform();
    }
}
