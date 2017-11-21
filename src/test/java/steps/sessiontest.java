package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sessiontest {

    public void sesion(){

        WebDriver driver = null;
        System.setProperty("webdriver.cheomw.driver",  "C:\\Selenium\\chromedriver.exe");
        driver = new FirefoxDriver();


    }
}
