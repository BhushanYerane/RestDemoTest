Feature: E-commerce API Testing

Scenario: Complete E-commerce API Workflow
    Given I am logged in with valid credentials
    When I add a new product
    Then the product is added successfully
    When I create an order with the added product
    Then the order is created successfully
    When I view the order details
    Then the order details are retrieved successfully
    When I delete the added product
    Then the product is deleted successfully