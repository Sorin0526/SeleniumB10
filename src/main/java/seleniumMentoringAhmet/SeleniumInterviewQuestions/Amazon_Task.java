package seleniumMentoringAhmet.SeleniumInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon_Task {
    @Test
    public void TestAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement signIn= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        signIn.click();
        WebElement create = driver.findElement(By.xpath(" //a[@id='createAccountSubmit']"));
        create.click();
        WebElement name = driver.findElement(By.xpath(" //input[@id='ap_customer_name']"));
        name.sendKeys("sorin");
        WebElement email = driver.findElement(By.xpath(" //input[@id='ap_email']"));
        email.sendKeys("sooorin@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//input[@id='ap_password']"));
        pass.sendKeys("123456");
        WebElement passConf= driver.findElement(By.xpath("//input[@id='ap_password_check'"));
        passConf.sendKeys("123456");
        WebElement submit = driver.findElement(By.xpath(" //input[@id='continue']"));
        submit.click();


    }
}