@checkout
Feature: Checkout Dashboard

  Background:
    Given User is logged in

  Scenario Outline: Order Checkout
    When User clicks on item with name "<itemName>"
    And User clicks on the add to cart button
    And User clicks on the shopping cart button
    And User clicks on the checkout
    And User adds the order info as "<firstName>", "<lastName>", "<zipCode>"
    And User clicks on continue button
    Then User sees the item matches with the "<itemName>"

    Examples:
      | itemName                 | firstName | lastName | zipCode |
      | Sauce Labs Backpack      | Mike      | Smith    | 12345   |
      | Sauce Labs Bike Light    | Mark      | Klein    | 12121   |
      | Sauce Labs Fleece Jacket | Laura     | Bell     | 13131   |