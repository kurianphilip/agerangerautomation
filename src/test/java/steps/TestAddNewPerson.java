package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class TestAddNewPerson {

    private WebDriver driver ;

    @When("^I add a person with first name as \"([^\"]*)\" and last name as \"([^\"]*)\"$")
    public void i_add_a_person_with_first_name_as_and_last_name_as(String firstname, String lastname) throws Throwable {

        System.setProperty("webdriver.chrome.driver",  "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://ageranger.azurewebsites.net/#/");
        Thread.sleep(5000);
        driver.findElement(By.className("fa-2x")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("FirstName")).sendKeys(firstname);
        driver.findElement(By.name("LastName")).sendKeys(lastname);

    }

    @When("^The person is of age \"([^\"]*)\"$")
    public void the_person_is_of_age(String age) throws Throwable {
        driver.findElement(By.name("Age")).sendKeys(age);
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.cssSelector("button[data-bb-handler^=confirm")).click();

    }


    @Then("^A new entry is created for 'firstName\"([^\"]*)\"lastName\"([^\"]*)\"ageGroup\"$")
    public void aNewEntryIsCreatedForFirstNameLastNameAgeGroup(String firstname, String agegroup) throws Throwable {

        WebElement agegroupTR = driver.findElement(By.xpath("//td[contains(text(), '"+firstname +"')]\\.."));
        WebElement elem = agegroupTR.findElement(By.cssSelector("td:nth-child(2)"));
        Assert.assertEquals(agegroup, elem.getAttribute("text"));
    }
}
