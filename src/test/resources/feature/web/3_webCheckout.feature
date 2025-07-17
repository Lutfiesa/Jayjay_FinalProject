Feature: Test Automation Web Checkout

  Background:
    Given open web login page
    And input valid username "standard_user" and password "secret_sauce"
    When click button login
    Then user will direct to homepage
    And user clicks "Add to cart" button for Item

  @checkout
  Scenario: User proceeds to checkout
    Given user is on the cart page
    And user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name "Esa"
    And user enters postal code "10130"
    When user clicks the Continue button
    Then user should be on the checkout overview page
    And user clicks the Finish button
    Then user should see a confirmation message "Thank you for your order!"

  @checkout
  Scenario: User fills firstname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name ""
    And user enters last name "Esa"
    And user enters postal code "10130"
    When user clicks the Continue button
    Then user should see a error message "Error: First Name is required"

  @checkout
  Scenario: User fills lastname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    And user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name ""
    And user enters postal code "10130"
    And user clicks the Continue button
    Then user should see a error message "Error: Last Name is required"

  @checkout
  Scenario: User fills zipcode blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    And user should be on the checkout information page
    And user enters first name "Lutfi"
    And user enters last name "Esa"
    And user enters postal code ""
    And user clicks the Continue button
    Then user should see a error message "Error: Postal Code is required"
