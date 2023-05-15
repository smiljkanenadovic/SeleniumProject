package testsWithLogin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;
import utilities.PropertyManager;

public class BaseTestWithLogin extends BaseTest {
    @Override
    @BeforeMethod
    public void setup(){
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(PropertyManager.getInstance().getValidUsername(), PropertyManager.getInstance().getValidPassword());
    }
}
