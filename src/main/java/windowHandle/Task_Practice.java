package windowHandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task_Practice {
    /*
    Navigate to the https://www.naukri.com/
click the LatentView Analytics Pvt Ltd.
Print all the titles
     */
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("");
        driver.manage().window().maximize();


    }
}
