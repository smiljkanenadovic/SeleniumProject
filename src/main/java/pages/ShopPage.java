package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.PropertyManager;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
    }
    By shopTabBy = By.xpath("//a[text()='Shop']");
    By cartTabBy = By.xpath("//a[text()='Cart']");
    By happyNinjaBy = By.xpath("//ul[@class='products columns-3']//li[2]");
    By addToCartBtnBy = By.xpath("//button[contains(@class, 'add_to_cart')]");

    public CartPage addHappyNinjaToCart() {
        clickElement(shopTabBy);
        clickElement(happyNinjaBy);
        clickElement(addToCartBtnBy);
        navigateToCartPage();
        return new CartPage(driver);
    }

    public void addFlyingNinja(){
        driver.navigate().to(PropertyManager.getInstance().getUrl() + "/product/flying-ninja/");
        clickElement(addToCartBtnBy);
        navigateToCartPage();
    }
    public void navigateToCartPage(){
        clickElement(cartTabBy);
    }
}
