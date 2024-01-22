Feature: As a user, I want to access to Vehicle Contracts page


  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that Store managers and Sales managers can access the Vehicle Contracts page.
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicle Contracts"
    Then the user should be able to see url as "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
    And the user should be able to see expected title as "All - Vehicle Contract - Entities - System - Car - Entities - System"

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |


  Scenario: Verify that driver user can NOT access the Vehicle Contracts page and the app displays "You do not have
  permission to perform this action."
    When the user logged in as "driver"
    And the user navigates to "Fleet" to "Vehicle Contracts"
    Then the user should be able to see message as "You do not have permission to perform this action."


