package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.NavigationBar;

import java.io.File;
import java.io.IOException;

public class AuthorizedBaseTest extends BaseTest {
    public String username = "harrypotter_g77@op.pl";
    public String password = "Gryfindor7&";
    @BeforeMethod(alwaysRun = true)
    public void login(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.openLoginPage()
                .succesfulLogin(username, password);
        logger.info("User logged in correctly");
    }

    @AfterMethod(alwaysRun = true)
    public void logout(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(file, new File(String.format("Screenshots/%s.png",
                        result.getMethod().getMethodName())));
            }catch (IOException e){
                System.err.println("Unable to create screenshot file "+e.getMessage());
            }
        }
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.logout();
        logger.info("User logged out successfully");
    }
}
