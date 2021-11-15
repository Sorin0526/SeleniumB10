package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow_Practice {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        // find the webelem for "clickhere "
        // -----//-------of new window text on the page
        // print the text

        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();

        String mainWindowId = driver.getWindowHandle();//123
        Set<String> ids= driver.getWindowHandles();//123, 124

        for(String id: ids){
            System.out.println(id
            );
            if(!id.equals(mainWindowId)){
                driver.switchTo().window(id);
            }
        }

        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        String actual = newWindow.getText();
        String expected = "New Window";
        Assert.assertEquals(actual,expected,"new window validation");

        driver.quit();// closes all the windows


    }
    @Test
    public void test2 (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();
        String mainWindowId = driver.getWindowHandle();//123
        Set<String> ids= driver.getWindowHandles();//123, 124
        //close only second window

        for (String id:ids
             ) {
            if(!id.equals(mainWindowId)){
                driver.switchTo().window(id);
                driver.close(); // close only one window that driver is pointing
            }
        }
        driver.switchTo().window(mainWindowId);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
