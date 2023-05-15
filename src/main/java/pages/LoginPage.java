package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By myAccountTabBy = By.xpath("//a[text()='My account']");
    By usernameInputFieldBy = By.id("username");
    By passwordInputFieldBy = By.id("password");
    By loginBtnBy = By.xpath("//button[contains(@class,'form-login__submit')]");
    By errorNotificationBy = By.xpath("//ul[@class='woocommerce-error']");

    public LoginPage performLogin(String username, String password){
        clickElement(myAccountTabBy);
        writeText(usernameInputFieldBy, username);
        writeText(passwordInputFieldBy, password);
        clickElement(loginBtnBy);
        return this;
    }

    public void verifyFailedLogin(String expectedError){
        assertStringEquals(readTextFromElement(errorNotificationBy), expectedError);
    }

    public void verifyLogout(String expectedText){
        assertStringEquals(readAttributeValue(loginBtnBy, "value"), expectedText);
    }

}
