Feature: Test Login Functionality of WebOrders application

  Background: Common Background Steps for Login Functionality
    Given user launches the browser
    And user navigates to the login page

  Scenario: Login Functionality Positive
    And user enters "Tester" in username input box
    And user enters "test" in password input box
    When user clicks on login button
    Then user should be navigated to orders page
    And user quits the browser

  Scenario: Login Functionality Negative
    And user enters "Tester" in username input box
    And user enters "test123!" in password input box
    When user clicks on login button
    Then user should see invalid login or password message
    And user quits the browser