package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUpdateAPerson {

    private WebDriver driver ;



    @When("^I update the details of a person with name \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_update_the_details_of_a_person_with_name_and(String firstname, String arg2) throws Throwable {
        System.setProperty("webdriver.chrome.driver",  "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://ageranger.azurewebsites.net/#/");
        Thread.sleep(5000);

        WebElement agegroupTR = driver.findElement(By.xpath("//td[contains(text(), '"+firstname +"')]\\.."));
        agegroupTR.findElement(By.className("fa-pencil")).click();

    }

    @When("^The details are updated with \"([^\"]*)\"$")
    public void the_details_are_updated_with(String firstnameUpdated) throws Throwable {

        driver.findElement(By.name("FristName")).sendKeys(firstnameUpdated);
        driver.findElement(By.tagName("form")).submit();
        driver.findElement(By.cssSelector("button[data-bb-handler^=confirm")).click();
    }

    @Then("^The new data for \"([^\"]*)\"  is displayed$")
    public void the_new_data_for_is_displayed(String firstnameUpated) throws Throwable {

        Thread.sleep(500);
        Assert.assertTrue(driver.getPageSource().contains(firstnameUpated));


    }


}
