package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDeleteAPerson {

    private WebDriver driver ;



    @When("^I delete a person of \"([^\"]*)\" and \"([^\"]*)\" from the application$")
    public void i_delete_a_person_of_and_from_the_application(String firstname, String lastname) throws Throwable {

        System.setProperty("webdriver.chrome.driver",  "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://ageranger.azurewebsites.net/#/");
        Thread.sleep(5000);

        WebElement agegroupTR = driver.findElement(By.xpath("//td[contains(text(), '"+firstname +"')]\\.."));
        agegroupTR.findElement(By.className("fa-trash")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[data-bb-handler^=confirm")).click();

    }

    @Then("^The entry \"([^\"]*)\" is deleted and the page is updated$")
    public void the_entry_is_deleted_and_the_page_is_updated(String firstname) throws Throwable {

        Assert.assertTrue(!driver.getPageSource().contains(firstname));

    }















}
