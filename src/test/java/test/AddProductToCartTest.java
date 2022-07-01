package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class AddProductToCartTest extends BaseTest{
    private static final String PRODUCT_NAME = "Pilla Zeiss Outlaw X RNK";
    private static final String PRODUCT_QUANTITY = "2";
    private static final String DESCRIPTION = "I am asking for fast shipping.";
    private static final String NAME_AND_SURNAME = "Harry Potter";
    private static final String ADDRESS = "Hogwart 77";
    private static final String ADDRESS_MORE = "Gryfindor Local 1";
    private static final String POSTCODE = "77-777";
    private static final String TOWN = "London";
    private static final String COUNTRY = "Polska";
    private static final String PHONE_NUMBER= "777-777-777";
    private static final String EMAIL = "harrypotter_g77@op.pl";
    private static final String ORDER_SUMMARY_TITLE = "Podsumowanie zamówienia";

    @Test(priority = 0)
    public void addProductTest() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.search(PRODUCT_NAME);
        logger.info("The user searched for a product");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.getFoundProductNames();
        searchResultsPage.openProductDetails(PRODUCT_NAME);
        logger.info("The user went to the product details");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart(PRODUCT_QUANTITY);
        logger.info("The user changed the number of items and clicked add to cart");
        productDetailsPage.addToCartPopup();
        productDetailsPage.goToOrderPage();
        logger.info("The user went to the order page");
        CartPage cartPage = new CartPage(driver);
        cartPage.addShippingAddress(DESCRIPTION, NAME_AND_SURNAME, ADDRESS, ADDRESS_MORE, POSTCODE,
                TOWN, COUNTRY, PHONE_NUMBER, EMAIL);
        logger.info("The user has filled in the required fields");
        cartPage.captcha();
        logger.info("A captcha appeared");
        Assert.assertTrue(cartPage.captcha(), "CaptchaInput is displayed.");

    }
}
