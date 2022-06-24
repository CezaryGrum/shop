package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NavigationBar;

import java.util.List;

public class LoginTest extends BaseTest{
    private static final String USER_NAME = "harrypotter_g77@op.pl";
    private static final String PASSWORD = "Gryfindor7&";

    @Test(priority = 0)
    public void unsuccessfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        List<String> errors = navigationBar.openLoginPage()
                .unsuccessfulLogin("invalidName","invalidPassword")
                .getErrors();
        List<String> expectedErrors = List.of("Zły login lub hasło.");
        Assert.assertEquals(errors, expectedErrors);
    }

    @Test(priority = 1)
    public void succesfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.openLoginPage()
                .succesfulLogin(USER_NAME,PASSWORD);
        String message = navigationBar.openUserAccountPage()
                .getCurrentlyLoggedInUser();
        Assert.assertTrue(message.contains(USER_NAME), String.format("Expected '%s' to be in '%s'",
                USER_NAME, message));
    }
}
