package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    By logoutBy = By.xpath("//a[text()='Logout']");

    public void verifyLogin(String expectedText){
        assertStringEquals(readTextFromElement(logoutBy), expectedText);
    }

    public LoginPage performLogout(){
        clickElement(logoutBy);
        return new LoginPage(driver);
    }

}
