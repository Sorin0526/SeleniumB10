package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;


public class AmazonStepsDefs {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;

    @When("I navigate to Amazon homepage")
    public void i_navigate_to_amazon_homepage() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.amazon.com/");


    }
    @And("I search for Iphone13 case")
    public void i_search_for_iphone13_case() {

        amazonHomePage= new AmazonHomePage(driver);
        amazonHomePage.search("Iphone 13 case");
//        WebElement searchField =  driver.findElement(By.id("twotabsearchtextbox"));
//        searchField.sendKeys("Iphone 13 case", Keys.ENTER);
//        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
//        searchButton.click();
    }
    @Then("I should get more than {int} results")
    public void i_should_get_more_than_results(Integer resultCount) {
        amazonSearchResultsPage= new AmazonSearchResultsPage(driver);
//    List<WebElement> resultsLinks=driver.findElements(By.tagName("a"));
        Assert.assertTrue(amazonSearchResultsPage.getResultsCount()>resultCount);
    }
    @Then("I validate the search result number")
    public void i_validate_the_search_result_number() {
        WebElement resultText = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String [] resultsArr= resultText.getText().split(" ");
        String resultsNum = resultsArr[3].replace(",","");
        int results = Integer.parseInt(resultsNum);
        Assert.assertEquals(results,20000);

    }

}
