package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CategoriesPage;
import pageObjects.NavigationBar;

public class SearchProductWithFiltersTest extends BaseTest{
    private static final String HEADING_TEXT = "Broń myśliwska kulowa";
    @Test
    public void searchWithFilters() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.goToCategoriesPage();
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.goTohuntingBallWeapon();
        String actualResults = categoriesPage.getHeading();
        String expectedResults = HEADING_TEXT;
        Assert.assertEquals(actualResults, expectedResults, "The header is correct");

    }
}
