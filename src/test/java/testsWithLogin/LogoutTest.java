package testsWithLogin;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class LogoutTest extends BaseTestWithLogin{
    @Test
    @Description("Test ID 5: Logout test.")
    public void logout(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.performLogout().verifyLogout("Log in");
    }
}
