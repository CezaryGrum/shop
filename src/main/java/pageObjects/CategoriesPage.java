package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pageObjects.HelperWaitingPage.waiterElementToBeClickable;

public class CategoriesPage extends BasePage{
    @FindBy (xpath = "//div//button/span[contains(@class, '')]")
    private WebElement sortBtn;
    @FindBy (xpath = "//div//ul//li//ul[contains(@class,'nav')]//li//a[contains(text(),'kulowa')]")
    private WebElement huntingBallWeapon;
    @FindBy (xpath = "//div[@id='product-navbar']//h1")
    private WebElement headingText;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPage() {
        waiterElementToBeClickable(sortBtn, driver);
    }
    public void goTohuntingBallWeapon(){
        huntingBallWeapon.click();
    }
    public String getHeading (){
        return headingText.getText();
    }
}
