package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility(By elementLocator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
    }

    public void waitClickability(By elementLocator){
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitClickability(WebElement webElement){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void writeText(By elementLocator, String text){
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public void clickElement(By elementLocator){
        waitVisibility(elementLocator);
        waitClickability(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void clickElement(WebElement elementToClick){
        waitClickability(elementToClick);
        elementToClick.click();
    }

    public void assertStringEquals(String actualText, String expectedText){
        Assert.assertEquals(actualText, expectedText);
    }

    public String readTextFromElement(By elementLocator){
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getText();
    }

    public String readAttributeValue(By elementLocator, String attributeName){
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getAttribute(attributeName);
    }

    public void clearAllInputFields(By elementLocator) {
         List<WebElement> elements = driver.findElements(elementLocator);
         for(int i = 0; i<elements.size(); i++){
             elements.get(i).clear();
         }
    }

}
