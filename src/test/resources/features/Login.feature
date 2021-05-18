@Login
Feature: Sauce Labs Login

  Scenario: Valid Login
    Given I am on the Login Page
    When I enter valid username
    And I enter valid password
    And I click on the login button
    Then I see the Home Page

  Scenario: Invalid Login
    Given I am on the Login Page
    When I enter invalid username
    And I enter invalid password
    And I click on the login button
    Then I see the error message on the Login Page