package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.NavigationBar;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

public class AuthorizedBaseTest extends BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public String username = readConfig.getUserLogin();
    public String password = readConfig.getPassword();
    @BeforeMethod(alwaysRun = true)
    public void login(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.openLoginPage()
                .succesfulLogin(username, password);
        logger.info("User logged in correctly");
    }

    @AfterMethod(alwaysRun = true)
    public void logout(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.logout();
        logger.info("User logged out successfully");
    }
}
