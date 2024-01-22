Feature: As a user (Sales and Store manager), I should be able to select any vehicle from the Vehicles page


  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that once the <userType> launch on the Vehicles page, the users can see all the checkboxes
  as unchecked.
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicles"
    Then the user should be able to see all the checkboxes as "unchecked"
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |



  Scenario Outline: Verify that <userType> can check the first checkbox to select all the cars
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicles"
    And the user select the all cars
    Then the user should be able to see all the checkboxes as "checked"
    Examples:
      | userType      |
      | store_manager |
      | sales_manager |



  Scenario Outline: Verify that <userType> can select any car
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicles"
    And the user select any car 5
    Then the user should be able to see car as "checked"
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
