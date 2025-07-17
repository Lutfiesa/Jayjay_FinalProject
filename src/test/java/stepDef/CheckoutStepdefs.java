package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ChekoutPage;

public class CheckoutStepdefs {

    CartPage cartPage;
    ChekoutPage chekoutPage;

    public CheckoutStepdefs(){
        this.cartPage = new CartPage();
        this.chekoutPage = new ChekoutPage();
    }

    @Given("user is on the cart page")
    public void userIsOnTheCartPage() {
        cartPage.clickCart();
        cartPage.validateOnCartPage();
    }

    @And("user clicks the Checkout button")
    public void userClicksTheCheckoutButton() {
        cartPage.userClicksTheCheckoutButton();
    }

    @Then("user should be on the checkout information page")
    public void userShouldBeOnTheCheckoutInformationPage() {
        chekoutPage.userShouldBeOnTheCheckoutInformationPage();
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String firstname) {
        chekoutPage.userEntersFirstName(firstname);
    }

    @And("user enters last name {string}")
    public void userEntersLastName(String lastname) {
        chekoutPage.userEntersLastName(lastname);
    }

    @And("user enters postal code {string}")
    public void userEntersPostalCode(String zipCode) {
        chekoutPage.userEntersPostalCode(zipCode);
    }

    @When("user clicks the Continue button")
    public void userClicksTheContinueButton() {
        chekoutPage.userClicksTheContinueButton();
    }

    @Then("user should be on the checkout overview page")
    public void userShouldBeOnTheCheckoutOverviewPage() {
        chekoutPage.userShouldBeOnTheCheckoutOverviewPage();
    }

    @And("user clicks the Finish button")
    public void userClicksTheFinishButton() {
        chekoutPage.userClicksTheFinishButton();
    }

    @Then("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String successMessage) {
        chekoutPage.userShouldSeeAConfirmationMessage(successMessage);
    }

    @Then("user should see a error message {string}")
    public void userShouldSeeAErrorMessage(String errorMessage) {
    }
}
