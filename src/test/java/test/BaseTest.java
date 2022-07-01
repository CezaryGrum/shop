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
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import javax.print.CancelablePrintJob;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    ReadConfig readConfig=new ReadConfig();

    public String chromepath = readConfig.getChromePath();
    public String firefoxpath = readConfig.getFirefoxPath();
    public String base_url = readConfig.getApplicationURL();
    public static Logger logger;
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String br) {
        logger = Logger.getLogger("SeleniumProject1");
        PropertyConfigurator.configure("Log4j.properties");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromepath);
            driver = new ChromeDriver();
        } else if (br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", firefoxpath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(base_url);
        driver.findElement(By.id("cookies_close")).click();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
        logger.info("The site has been closed");
    }


}
