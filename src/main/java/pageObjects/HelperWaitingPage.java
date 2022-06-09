package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperWaitingPage extends BasePage{
    public HelperWaitingPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPage() {

    }
    public static void waiterElementToBeClickable(WebElement element, WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waiterElementToBeVisible(WebElement element, WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitAndClick (WebElement element, WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
