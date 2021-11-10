package actionsPractice;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.rmi.activation.ActivationInstantiator;

public class SliderPractice {

    @Test
    public  void sliderTest(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");


        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.tagName("input"));
        WebElement text = driver.findElement(By.id("range"));
        navigateToTarget(slider,text, driver, 4.5);
        actions.clickAndHold(slider).moveByOffset(40,0).perform();

        Point point = slider.getLocation();
        System.out.println(point.getX());
        System.out.println(point.getY());

        //source --> target
        //find webelement for target than using point class and also get location method, you can provide the x and y coordinates

        // tas : create a function that takes WebElem, driver, and target number
        // navigate to target(slider, driver, 5)



    }
    public static void navigateToTarget (WebElement slider, WebElement text, WebDriver driver, double targetNum ) {

        Actions actions = new Actions(driver);

        if (targetNum == 2.5) {
            actions.click().perform();
        } else if (targetNum > 2.5) {
            int count = 10; // target 3.5
            while (!text.getText().equals(String.valueOf(targetNum))) {
                actions.clickAndHold(slider).moveByOffset(count, 0).perform();
                count += 5;
            }

        } else {
            int count = -10;
            while (!text.getText().equals(String.valueOf(targetNum))) {
                actions.clickAndHold(slider).moveByOffset(count, 0).perform();
                count -= 5;
            }
        }

    }
}