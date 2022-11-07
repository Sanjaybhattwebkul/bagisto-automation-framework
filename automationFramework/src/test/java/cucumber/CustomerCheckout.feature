@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Velocity Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  		       					|  password    |   productName |
      | sanjay.bhatt371@webkul.in |  admin123    |   ZARA COAT 3 | 
