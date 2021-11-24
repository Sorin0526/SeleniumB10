package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

import java.util.Set;

public class Iframe_Task {
    /*
TASK:
1- GO to the https://skpatro.github.io/demo/iframes/
2- click category1
3- from new page validate the title is ending with 'qavalidation'
4- Click category3
5- validate the new url is
equals to "https://qavalidation.com/category/softwaretesting/"
 */
    @Test
    public void pageValidation(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

//        driver.switchTo().frame("Framename1");
//        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
//        category1.click();
//
//        String mainWindow = driver.getWindowHandle();
//        Set<String> handles = driver.getWindowHandles();
//
//        for  (String window: handles
//             ) {
//            if(!mainWindow.equals(window))
//                driver.switchTo().window(window);
//
//        }
//
//        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
//        String expectedTitle = "SeleniumTesting Archives - qavalidation";
//
//        Assert.assertEquals(actualTitle,expectedTitle);
//
//        driver.switchTo().window(mainWindow);
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("Frame2");
//        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
//        category3.click();
//        Browsers_Utils.switchByTitle(driver,"SoftwareTesting");
//
//        String url = driver.getCurrentUrl();
//        String expected = "https://qavalidation.com/category/softwaretesting/";
//        Assert.assertEquals(url,expected);
//
//        driver.quit();// GET DAVID'S VERSION FROM GITHUB

        driver.switchTo().frame("Frame1");
        WebElement cat1=driver.findElement(By.linkText("Category1"));
        cat1.click();
        Browsers_Utils.switchByTitle(driver, "SeleniumTesting");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        driver.close(); // it will close the SeleniumTesting window
        // after closing the SeleniumTesting window, driver will not go back to the main page.
        // We should switch back to the main window.
        Browsers_Utils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Frame2");
        WebElement cat3=driver.findElement(By.linkText("Category3"));
        cat3.click();
        Browsers_Utils.switchByTitle(driver,"SoftwareTesting");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qavalidation.com/category/softwaretesting/");

        driver.quit();







    }
}
