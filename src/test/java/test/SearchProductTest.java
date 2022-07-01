package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.NavigationBar;
import pageObjects.SearchResultsPage;
import utilities.ReadConfig;

import java.util.ArrayList;
import java.util.List;

import static pageObjects.BasePage.driver;

public class SearchProductTest extends AuthorizedBaseTest {
    ReadConfig readConfig = new ReadConfig();
    private static final String NOT_EXISTING_PRODUCT = "okulary123";
    private static final String NO_PRODUCT_FOUND = "Brak produktów dla podanego wyszukiwania. " +
            "Spróbuj wpisać inne wyrażenie lub poszukać produktu, korzystając z kategorii sklepu.";
    private static final String FIRST_PRODUCT_NAME = "Okulary PILLA Outlaw X6";
    private static final String SECOND_PRODUCT_NAME = "Okulary PILLA Outlaw X7";
    private static final String THIRD_PRODUCT_NAME = "Pilla Zeiss Outlaw X 3D";
    private static final String FOURTH_PRODUCT_NAME = "Pilla Zeiss Outlaw X RNK";

    @Test(priority = 0)
    public void noProductFoundTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.search(NOT_EXISTING_PRODUCT);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String actualResults = searchResultsPage.getMessageNoResultsFound();
        String expectedResults = NO_PRODUCT_FOUND;
        Assert.assertEquals(actualResults, expectedResults);
        logger.info("The user searched for a non-existent product");
    }
    @Test(priority = 1)
    public void multipleFoundResultWithCommonName(){
        NavigationBar navigationBar = new NavigationBar(driver);
        List<String> foundResults = navigationBar.search("okulary Pilla Outlaw")
                .getFoundProductNames();
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add(FIRST_PRODUCT_NAME);
        expectedResults.add(SECOND_PRODUCT_NAME);
        expectedResults.add(THIRD_PRODUCT_NAME);
        expectedResults.add(FOURTH_PRODUCT_NAME);

        SoftAssert softAssert = new SoftAssert();
        for (String expectedResult:expectedResults){
            softAssert.assertTrue(foundResults.contains(expectedResult),
                    String.format("Expected product '%s' to be found in search results, instead found: [%s]",
                            expectedResult, foundResults));
        }
        softAssert.assertAll();
        logger.info("The user searched for an existing product");
    }
    }
