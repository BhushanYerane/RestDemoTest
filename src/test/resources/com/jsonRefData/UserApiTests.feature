Feature: User API tests with complex JSON

  Scenario: Create a user with complex JSON
    Given the base URL is "https://gorest.co.in/public/v2"
    When I send a POST request to "/users" with complex body:
      """
      {
          "name": "John Doe",
          "gender": "male",
          "email": "johndoe@example.com",
          "status": "active",
          "address": {
              "street": "123 Main St",
              "city": "Anytown",
              "state": "CA",
              "postalCode": "12345"
          },
          "phones": [
              {
                  "type": "home",
                  "number": "123-456-7890"
              },
              {
                  "type": "work",
                  "number": "987-654-3210"
              }
          ],
          "projects": [
              {
                  "name": "Project A",
                  "role": "Developer",
                  "technologies": ["Java", "Spring", "REST"]
              },
              {
                  "name": "Project B",
                  "role": "Lead",
                  "technologies": ["JavaScript", "React", "Node.js"]
              }
          ]
      }
      """
    Then the status code should be 201
    And the content type should be "application/json"
    And the response should contain "name" with value "John Doe"
    And the response should contain "address.street" with value "123 Main St"
    And the response should contain "phones[0].type" with value "home"
    And the response should contain "phones[1].number" with value "987-654-3210"
    And the response should contain "projects[0].name" with value "Project A"
    And the header "Content-Type" should be "application/json; charset=utf-8"
