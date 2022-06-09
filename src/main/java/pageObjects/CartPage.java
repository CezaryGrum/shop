package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class CartPage extends BasePage {

    @FindBy(xpath = "//input[@name=\"delivery[default_payment]\" and @value=\"12\"]")
    private WebElement cashOnDeliveryRBtn;
    @FindBy(id = "order_description_text")
    private WebElement orderDescriptionInput;
    @FindBy(id = "full_name_billing")
    private WebElement nameAndSurnameInput;
    @FindBy(id = "address_billing")
    private WebElement addressInput;
    @FindBy(id = "address_more_billing")
    private WebElement addressMoreInput;
    @FindBy(id = "code_billing")
    private WebElement postcodeInput;
    @FindBy(id = "town_billing")
    private WebElement townInput;
    @FindBy(id = "user_data_billing_country")
    private WebElement countrySelect;
    @FindBy(id = "phone_billing")
    private WebElement phoneInput;
    @FindBy(id = "email_billing")
    private WebElement emailInput;
    @FindBy(id = "user_data_billing_terms")
    private WebElement termsCheckbox;
    @FindBy(id = "captcha_img")
    private WebElement captchaInput;
    @FindBy(name = "submit_save")
    private WebElement submitSaveBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {

    }
    public OrderConfirmationPage addShippingAddress(String description, String nameAndSurmane, String address,
                                                    String addressMore, String postcode, String town, String country,
                                                    String phone, String email){
        cashOnDeliveryRBtn.click();
        waiterElementToBeClickable(orderDescriptionInput, driver);
        orderDescriptionInput.click();
        orderDescriptionInput.sendKeys(description);
        nameAndSurnameInput.sendKeys(nameAndSurmane);
        addressInput.sendKeys(address);
        addressMoreInput.sendKeys(addressMore);
        postcodeInput.sendKeys(postcode);
        townInput.sendKeys(town);
        Select c = new Select(countrySelect);
        c.selectByVisibleText(country);
        phoneInput.sendKeys(phone);
        emailInput.sendKeys(email);
        termsCheckbox.click();
        return new OrderConfirmationPage(driver);
    }
    public OrderConfirmationPage clickOnSubmitSaveBtn (){
        submitSaveBtn.click();
        return new OrderConfirmationPage(driver);
    }
    public boolean captcha (){
        if (captchaInput.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }
    public OrderConfirmationPage payLabel(String description){
        cashOnDeliveryRBtn.click();
        waiterElementToBeClickable(orderDescriptionInput, driver);
        orderDescriptionInput.sendKeys(description);
        return new OrderConfirmationPage(driver);
    }
}
