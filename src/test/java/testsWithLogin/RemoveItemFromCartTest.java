package testsWithLogin;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ShopPage;

public class RemoveItemFromCartTest extends BaseTestWithLogin{
   @Test
   @Description("Test ID 6: Removing item from the cart.")
    public void removeItemFromCartTest(){
      ShopPage shopPage = new ShopPage(driver);
      shopPage.addHappyNinjaToCart();
      CartPage cartPage = new CartPage(driver);
      cartPage.removeItemWithSpecificName("Happy Ninja").verifyItemIsRemovedFromCart("“Happy Ninja” removed. Undo?");
   }
}
