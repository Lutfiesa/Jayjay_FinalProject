package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Utility.driver;
import static helper.Utility.wait;

public class CartPage {

    By page_cart = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By button_checkout = By.xpath("//button[@id='checkout']");
    By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    public void clickCart() {
        WebElement cartBadge = driver.findElement(cart);
        Assert.assertTrue(cartBadge.isDisplayed());
        cartBadge.click();
    }

    public void validateOnCartPage() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(page_cart, "Your Cart"));
        WebElement textCart = driver.findElement(page_cart);
        Assert.assertTrue(textCart.isDisplayed());
        Assert.assertEquals("Your Cart", textCart.getText());
    }

    public void userClicksTheCheckoutButton() {
        driver.findElement(button_checkout).click();
    }

}
