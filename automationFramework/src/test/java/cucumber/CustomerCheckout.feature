@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Velocity Page

  @CustomerCheckout
  Scenario Outline: Positive Test of Submitting the order
  
    Given I add product <productName> to Cart
    When Logged in with username <name> and password <password>
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  		      |  password |   productName  |
      | tom@example.com |  tom123   |   Sunglasses   | 
