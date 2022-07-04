package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class BasePage {
    public Properties prop;
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPage();
    }
    public abstract void waitForPage();
    public void loadProperties ()throws IOException{
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/properties/data.properties");
        prop.load(fis);
    }
}
