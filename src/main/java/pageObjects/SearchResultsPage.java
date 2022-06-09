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

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@id='content']/form/div/span/button")
    private WebElement resultsSearchBtn;
    @FindBy(css = "//div[@id='full-list']//a[@class='product_name'][1]")
    private WebElement productNameLabel;
    @FindBy(xpath = "//a[contains(text(),'Do koszyka')]")
    private WebElement cartBtn;
    @FindBy(css = ".clearfix > .name > .product_name")
    private List<WebElement> productNameLabels;
    @FindBy(xpath = "//div[@id='content']//div[text()='Brak produktów dla podanego wyszukiwania." +
            " Spróbuj wpisać inne wyrażenie lub poszukać produktu, korzystając z kategorii sklepu.']")
    private WebElement noResultsFound;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waiterElementToBeClickable(resultsSearchBtn, driver);
    }

    public String getMessageNoResultsFound() {
        return noResultsFound.getText();
    }
    public List<String> getFoundProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement errorMessageLabel : productNameLabels) {
            productNames.add(errorMessageLabel.getText());
        }
        return productNames;
    }

    public ProductDetailsPage openProductDetails(String productName) {
        for (WebElement productNameLabel : productNameLabels) {
            if (productNameLabel.getText().equals(productName)) {
                productNameLabel.click();
                return new ProductDetailsPage(driver);
            }
        }
        throw new RuntimeException("Unable to find product with name "+productName);
    }
}
