package select_Class;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

public class Select_Intro {

    @Test
    public void test () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        String actualFirstSelected = select.getFirstSelectedOption().getText().trim();
        String expectedFirstSelected ="Please select an option";


        Thread.sleep(3000);// my code ill pass on this line for two secs
        select.selectByValue("1");
        Thread.sleep(2000);

        select.selectByVisibleText("Option 2");
        Thread.sleep(2000);

        select.selectByIndex(1);

        Assert.assertEquals(actualFirstSelected,expectedFirstSelected,"first selected");// hard assert is recommended at the end of the code
        // actual first , expected second --ALWAYS!!!





        Thread.sleep(10000);
        driver.quit();
    }

}
