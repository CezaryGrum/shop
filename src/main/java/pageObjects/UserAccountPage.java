package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class UserAccountPage extends BasePage{
    @FindBy(xpath = ".//div[@id='user-panel-login']")
    private WebElement currentlyLoggedInUser;
    @FindBy(xpath = "//div[@id='search-top']/form/div/span/button")
    private WebElement logoutBtn;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(logoutBtn, driver);
    }
    public String getCurrentlyLoggedInUser(){
        return currentlyLoggedInUser.getText();
    }
}
