package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@id='search-top']/form/div/span/button")
    private WebElement searchButton;
    @FindBy(xpath = ".//div/p/a[contains(text(),'Wróć do zakupów')]")
    private WebElement comebackButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(searchButton, driver);
    }
    public boolean getComebackBtn(){
        comebackButton.isDisplayed();
        return true;
    }
}
