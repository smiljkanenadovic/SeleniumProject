package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By firstNameInputBy = By.id("billing_first_name");
    By lastNameInputBy = By.id("billing_last_name");
    By selectCountryBy = By.id("billing_country");
    By addressInputBy = By.id("billing_address_1");
    By cityInputBy = By.id("billing_city");
    By postcodeInputBy = By.id("billing_postcode");
    By phoneInputBy = By.id("billing_phone");
    By emailInputBy = By.id("billing_email");
    By placeOrderBtnBy = By.xpath("//button[@value='Place order']");
    By allInputFieldsBy = By.xpath("//input[contains(@id, 'billing') and not (@id='billing_state') and not(@id='billing_address_2') and not(@id='billing_country_field')]");
    By orderReceivedBy = By.xpath("//p[contains(@class, 'thankyou-order-received')]");

    public CheckoutPage fillCheckoutData(String name, String lastName, String countryName, String address, String city, String postcode, String phone, String email){
        clearAllInputFields(allInputFieldsBy);
        writeText(firstNameInputBy, name);
        writeText(lastNameInputBy, lastName);
        Select country = new Select(driver.findElement(selectCountryBy));
        country.selectByVisibleText(countryName);
        writeText(addressInputBy, address);
        writeText(cityInputBy, city);
        writeText(postcodeInputBy, postcode);
        writeText(phoneInputBy, phone);
        writeText(emailInputBy, email);

        try {
            WebElement placeOrder = driver.findElement(placeOrderBtnBy);
            clickElement(placeOrder);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement placeOrder = driver.findElement(placeOrderBtnBy);
            clickElement(placeOrder);
        }
        return this;
    }
    public void verifyOrderReceived(String expectedText){
        assertStringEquals(readTextFromElement(orderReceivedBy), expectedText);
    }
}
