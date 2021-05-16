@amazon
Feature: Testing Swaglabs application

  @Scenario1
  Scenario: Checkout and validate the product
    Given Launches application and Login
    And Add the product to the cart
    Then Checkout and validate the product details whether you are ordered the correct product

  @Scenario2
  Scenario: Get all the product lists and check the particular product
    Given Launches application and Login
    Then Get all the product lists and check the particular product "Sauce Labs Bolt T-Shirt" is available.

  @Scenario3
  Scenario: Validate the price with product listing with product individual page
    Given Launches application and Login
    And Get the price of all products and remove the dollar symbol
    Then Validate the price with product listing with product individual page

  @Scenario4
    Scenario: Validate the error message  
    Given Launches application and Login via invalid username
    Then Validate the error message