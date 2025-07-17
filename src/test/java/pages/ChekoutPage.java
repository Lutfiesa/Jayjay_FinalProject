package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Utility.driver;
import static helper.Utility.wait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChekoutPage {

    By CheckoutInfoPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By FirstName = By.id("first-name");
    By LastName = By.id("last-name");
    By ZipCode = By.id("postal-code");
    By button_continue = By.xpath("//input[@id='continue']");
    By CheckoutOverView = By.xpath("//span[@class='title' and contains(text(),'Checkout: Overview')]");
    By CheckoutCompletePage = By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']");
    By buttonFinish = By.id("finish");

    public void userShouldBeOnTheCheckoutInformationPage() {
        WebElement textCheckoutInfoPage = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutInfoPage));
        assertTrue(textCheckoutInfoPage.isDisplayed());
        assertEquals("Checkout: Your Information", textCheckoutInfoPage.getText());
    }

    public void userEntersFirstName(String firstname){
        driver.findElement(FirstName).sendKeys(firstname);
    }

    public void userEntersLastName(String lastname){
        driver.findElement(LastName).sendKeys(lastname);
    }

    public void userEntersPostalCode(String zipcode){
        driver.findElement(ZipCode).sendKeys(zipcode);
    }

    public void userClicksTheContinueButton(){
        driver.findElement(button_continue).click();
    }

    public void userShouldBeOnTheCheckoutOverviewPage(){
        WebElement textCheckoutOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutOverView));
        Assert.assertTrue(textCheckoutOverview.isDisplayed());
        Assert.assertEquals("Checkout: Overview", textCheckoutOverview.getText());
    }

    public void userClicksTheFinishButton(){
        driver.findElement(buttonFinish).click();
    }

    public void userShouldSeeAConfirmationMessage(String succesMessage){
        WebElement textCheckoutOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutCompletePage));
        Assert.assertEquals(succesMessage, textCheckoutOverview.getText());
    }

    public void userShouldSeeAErrorMessage(String errorMessage){
        assertTrue(driver.getPageSource().contains(errorMessage));
    }
}
