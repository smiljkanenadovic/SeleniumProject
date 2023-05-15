package testsWithLogin;

import dataGenerator.DataProviders;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ShopPage;


public class BuyingItemTest extends BaseTestWithLogin {
    @Test(dataProvider="fillCheckoutData", dataProviderClass = DataProviders.class)
    @Description("Test ID 7 Buying item and verifying order.")
    public void buyingItem(String name, String lastName, String countryName, String address, String city, String postcode, String phone, String email){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.addHappyNinjaToCart().proceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutData(name, lastName, countryName, address, city, postcode, phone, email)
                    .verifyOrderReceived("Thank you. Your order has been received.");
    }
}
