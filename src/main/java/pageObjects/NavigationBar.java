package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class NavigationBar extends BasePage{
    @FindBy(id = "nav-button-user2")
    private WebElement myAccount;
    @FindBy(xpath = "//div[@id='search-top']/form/div/span/button")
    private WebElement searchBtn;
    @FindBy(name = "query")
    private WebElement searchInput;
    @FindBy (xpath = "//a[contains(.,'Wyloguj')]")
    private WebElement logoutBtn;
    @FindBy (xpath = "//div[contains(@id,'menu')]/ul/li[1]")
    private WebElement navMenuFirstDropdown;


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(searchBtn, driver);
    }
    public LoginPage openLoginPage(){
        myAccount.click();
        return new LoginPage(driver);
    }
    public UserAccountPage openUserAccountPage(){
        myAccount.click();
        return new UserAccountPage(driver);
    }
    public NavigationBar logout()
    {
        myAccount.click();
        logoutBtn.click();
        return new NavigationBar(driver);
    }
    public SearchResultsPage search(String productName){
        searchInput.sendKeys(productName);
        searchBtn.click();
        return new SearchResultsPage(driver);
    }
    public CategoriesPage goToCategoriesPage(){
        navMenuFirstDropdown.click();
        return new CategoriesPage(driver);
    }
}
