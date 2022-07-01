package test;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    ReadConfig readConfig=new ReadConfig();

    public String chromepath = readConfig.getChromePath();
    public String firefoxpath = readConfig.getFirefoxPath();
    public String base_url = readConfig.getApplicationURL();
    public static Logger logger;
    public static WebDriver driver;

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
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


}
