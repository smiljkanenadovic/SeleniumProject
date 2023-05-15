package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    By proceedToCheckOutBtnBy = By.className("wc-proceed-to-checkout");
    By itemRemovedMsgBy = By.className("woocommerce-message");
    By allItemsInTheCartBy = By.xpath("//tr[contains(@class,'cart_item')]");
    By allRemoveBtnFromCartBy = By.xpath("//td[(@class='product-remove')]/a[1]");
    By allItemsNameBy = By.xpath("//td[(@class='product-name')]");

    public void proceedToCheckout(){
        clickElement(proceedToCheckOutBtnBy);
    }

    public WebElement returnItemWithSpecificName(By elementLocator, By itemNameLocator, String itemName){
        List<WebElement> itemsList = driver.findElements(elementLocator);
        WebElement elementWithSpecificName = null;
        for(WebElement element : itemsList){
            String item = element.findElement(itemNameLocator).getText();
            if(item.equals(itemName)){
                elementWithSpecificName = element;
                break;
            }
        }
        return elementWithSpecificName;
    }
    public CartPage removeItemWithSpecificName(String itemName){
        WebElement element = returnItemWithSpecificName(allItemsInTheCartBy, allItemsNameBy, itemName);
        element.findElement(allRemoveBtnFromCartBy).click();
        return this;
    }

    public void verifyItemIsRemovedFromCart(String expectedText){
        assertStringEquals(readTextFromElement(itemRemovedMsgBy), expectedText);
    }
}
