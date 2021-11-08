package select_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browsers_Utils;

public class Cars_Select {

    /*
    TASK: https://www.cars.com/
Select New car - Porche - 911
Click search button
Validate header is equals to "New Porsche 911 for sale"
     */

    @Test
    public void testCars() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.cars.com/");

        WebElement newCars = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
//        Select select = new Select(newCars);
//        select.selectByValue("new");
        Browsers_Utils.selectBy(newCars, "New cars","text");
        Thread.sleep(2000);

        WebElement make = driver.findElement(By.id("makes"));
//        Select select1 = new Select(make);
//        select1.selectByValue("porsche");
        Browsers_Utils.selectBy(make, "porche","value");

        Thread.sleep(2000);

        WebElement model = driver.findElement(By.id("models"));
//        Select select2 = new Select(model);
//        select2.selectByValue("porsche-911");
        Browsers_Utils.selectBy(model, "porsche-911", "index");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//button[@data-activity-rule-type='page-over-page']"));
        search.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        //String actual = header.getText().trim();
        String actual = Browsers_Utils.getText(header);
        String expected = "New Porsche 911 for sale";


        Assert.assertEquals(actual,expected);

        Thread.sleep(10000);
        driver.quit();
    }
}
