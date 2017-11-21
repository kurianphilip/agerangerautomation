package steps;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteBrowserTest {


        WebDriver driver=null;

       @Test
        public void setup() {

           System.setProperty("webdriver.chrome.driver",  "C:\\Selenium\\chromedriver.exe");
           driver = new ChromeDriver();
           HttpCommandExecutor executor = (HttpCommandExecutor)driver.getcom

           driver.get("http://www.google.com");
       }


       @Test
        public void browser_test() throws MalformedURLException {
           URL uri = new URL("http://localhost:7055/hub");
           driver = new RemoteWebDriver(uri, DesiredCapabilities.firefox());
           System.out.println("Executed on remote driver");
           driver.findElement(By.name("q"));


       }





}
