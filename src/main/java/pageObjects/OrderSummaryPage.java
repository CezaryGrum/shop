package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static pageObjects.HelperWaitingPage.*;

public class OrderSummaryPage extends BasePage {

    @FindBy(xpath = ".//button[@id='st_order-back_button']")
    private WebElement goBackToTheCart;
    @FindBy(xpath = ".//div[@id='order-confirm']/div/h1")
    private WebElement orderSummaryTitle;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(goBackToTheCart, driver);
    }
    public String getOrderSummaryTitle(){
        return orderSummaryTitle.getText();
    }
}
