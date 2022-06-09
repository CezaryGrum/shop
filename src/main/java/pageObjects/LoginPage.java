package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class LoginPage extends BasePage {
    @FindBy(id = "st_form-user-email")
    private WebElement emailInput;

    @FindBy(id = "st_form-user-password")
    private WebElement passwordInput;

    @FindBy(name = "submit_login")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {

    }
    public MainPage succesfulLogin(String login, String password){
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new MainPage(driver);
    }

    public BadLoginPage unsuccessfulLogin(String login, String password){
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new BadLoginPage(driver);
    }
}
