package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.*;


public class AddProductToCartLoggedUserTest extends AuthorizedBaseTest{
    private static final String PRODUCT_NAME = "Pilla Zeiss Outlaw X RNK";
    private static final String PRODUCT_QUANTITY = "2";
    private static final String DESCRIPTION = "I am asking for fast shipping.";
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
        cartPage.payLabel(DESCRIPTION);
        cartPage.clickOnSubmitSaveBtn();
        logger.info("The user filled in the required fields and went to the order summary view");
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        String message = orderSummaryPage.getOrderSummaryTitle();
        Assert.assertTrue(message.contains(ORDER_SUMMARY_TITLE), String.format("Expected '%s' to be in '%s'",
                ORDER_SUMMARY_TITLE, message));
    }
}
