Feature: Test Automation Web Checkout

  Background:
    Given open web login page
    And click login add header bar
    And input valid username "lutfiesa" and password "123123"
    When click button login
    Then login add header change to logout

  Scenario: User proses checkout item
    Given user click product