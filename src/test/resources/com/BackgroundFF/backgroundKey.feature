Feature: testing background keyword

Background: Login and get response
		Given login to application and get response
  
  Scenario: Check status code
    Then validate the status code
    
  Scenario: validate title
    Then validate Git Pocket Guide title is present