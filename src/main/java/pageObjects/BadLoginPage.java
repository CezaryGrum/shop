package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static pageObjects.HelperWaitingPage.*;

public class BadLoginPage extends BasePage{

    @FindBy(xpath = "//div[2]/form/div/label")
    private List<WebElement> errorMessageLabels;
    @FindBy(name = "submit_login")
    private WebElement loginBtn;


    public BadLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(loginBtn, driver);
    }
    public List<String> getErrors(){
        List<String> errors = new ArrayList<>();
        for (WebElement errorMessageLabel: errorMessageLabels){
            errors.add(errorMessageLabel.getText());
        }
        return errors;
    }
}
