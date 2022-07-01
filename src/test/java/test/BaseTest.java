package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.print.CancelablePrintJob;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public String BaseURL="https://besthunters.pl/";
    public static Logger logger;
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.findElement(By.id("cookies_close")).click();
        logger = Logger.getLogger("SeleniumProject1");
        PropertyConfigurator.configure("Log4j.properties");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
        logger.info("The site has been closed");
    }


}
