Feature: Check if the application is up

  Scenario: Application should return 200 OK status
    Given the application is running
    When I check the application status
    Then the status should be 200 OK
