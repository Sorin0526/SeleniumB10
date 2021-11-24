package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe_Practice {

    //navigate to "https://the-internet.herokuapp.com/iframe"
    //delete the text
    //sendkey ello Java! into the text box

        @Test
        public void test (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement text = driver.findElement(By.id("tinymce"));
        text.clear();
        text.sendKeys("Hello Java!");

        driver.switchTo().parentFrame();
        WebElement title = driver.findElement(By.tagName("h3"));
        String actualTitle = title.getText().trim();
        String expectedTitle = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualTitle,expectedTitle);


    }
}
