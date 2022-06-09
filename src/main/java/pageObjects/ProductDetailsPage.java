package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class ProductDetailsPage extends BasePage{
    @FindBy(xpath = "//h1")
    private WebElement productName;
    @FindBy(xpath = "//li/input")
    private WebElement quantityInput;
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    private WebElement addToCartBtn;
    @FindBy(xpath = ".//div[@id='shopping-cart-product-preview']/div/div/div/h4")
    private WebElement productHasBeenAddedToTheCartHeaderOnPopup;
    @FindBy(xpath = ".//div[@id='shopping-cart-product-preview']/div/div/div[@class='modal-footer']/button")
    private WebElement continueShopping;
    @FindBy(id = "nav-button-shopping-cart2")
    private WebElement cartButton;
    @FindBy(xpath = "//a[contains(text(),'Zamów')]")
    private WebElement orderBtn;



    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(addToCartBtn, driver);
    }

    public ProductDetailsPage addToCart (String productQuantity) {
        quantityInput.clear();
        quantityInput.sendKeys(productQuantity);
        addToCartBtn.click();
        return new ProductDetailsPage(driver);
    }
    public ProductDetailsPage addToCartPopup () {
        waiterElementToBeClickable(continueShopping, driver);
        continueShopping.click();
        return new ProductDetailsPage(driver);
    }
    public CartPage goToOrderPage (){
        cartButton.click();
        orderBtn.click();
        return new CartPage(driver);
    }


}
