package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Utility.driver;
import static helper.Utility.wait;

public class HomePage {

    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By productRemove = By.id("remove-sauce-labs-backpack");

    public void addItemToCart() throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(product1));
        Assert.assertTrue(addButton.isDisplayed());

        try {
            addButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(product1));
    }

    public void validateRemoveButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productRemove));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productRemove, "Remove"));
        WebElement removeButton = driver.findElement(productRemove);
        Assert.assertTrue(removeButton.isDisplayed());
        Assert.assertEquals("Remove", removeButton.getText());
    }

    public void validateCartCount(int expectedCount) {
        WebElement cartBadge = driver.findElement(cart);
        Assert.assertTrue(cartBadge.isDisplayed());
        Assert.assertEquals(String.valueOf(expectedCount), cartBadge.getText());
    }

//    public void clickCart() {
//        WebElement cartBadge = driver.findElement(cart);
//        Assert.assertTrue(cartBadge.isDisplayed());
//        cartBadge.click();
//    }

}
