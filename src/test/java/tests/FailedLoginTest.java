package tests;

import dataGenerator.DataProviders;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest {
    @Test(dataProvider = "failedLogin", dataProviderClass = DataProviders.class)
    @Description("Test ID 1, ID 2, ID 3: Failed login tests.")
    public void failedLogin(String username, String password, String errorMessage){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(username, password).verifyFailedLogin(errorMessage);
    }
}
