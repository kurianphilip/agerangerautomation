package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearchAPerson {


    private WebDriver driver ;


    @When("^I search for a particular person with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_search_for_a_particular_person_with_and(String firstname, String lastname) throws Throwable {

        System.setProperty("webdriver.chrome.driver",  "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://ageranger.azurewebsites.net/#/");
        Thread.sleep(5000);
        driver.findElement(By.id("searchText")).sendKeys(firstname + " " + lastname);


    }

    @Then("^The result for \"([^\"]*)\" is displayed by the application$")
    public void the_result_for_is_displayed_by_the_application(String firstname) throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//tr/td[contains(text(), '"+ firstname + "')]")) != null);

    }



}
