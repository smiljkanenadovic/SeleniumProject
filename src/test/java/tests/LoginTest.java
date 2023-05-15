package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest{
    @Test
    @Description("Test ID 4: Successful login test.")
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword());
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyLogin("Logout");
    }
}
