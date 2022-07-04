package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NavigationBar;
import utilities.ReadConfig;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest{
    ReadConfig readConfig = new ReadConfig();
    public String USER_NAME = readConfig.getUserLogin();
    public String PASSWORD = readConfig.getPassword();
    public String BAD_USER_NAME = readConfig.getWrongUserLogin();
    public String BAD_PASSWORD = readConfig.getWrongPassword();

    @Test(priority = 0)
    public void unsuccessfulLoginTest() throws IOException {
        NavigationBar navigationBar = new NavigationBar(driver);
        List<String> errors = navigationBar.openLoginPage()
                .unsuccesfulLogin(BAD_USER_NAME,BAD_PASSWORD)
                .getErrors();
        List<String> expectedErrors = List.of("Zły login lub hasło.");
        captureScreen(driver, "unsuccessfulLoginTest");
        Assert.assertEquals(errors, expectedErrors);
        logger.info("User is not logged in");
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
        logger.info("User is logged");
    }
}
