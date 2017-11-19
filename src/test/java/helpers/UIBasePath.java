package helpers;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIBasePath {

    private WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void BaseURL() {
        driver.get("http://ageranger.azurewebsites.net/#/");
    }

}
